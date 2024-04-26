package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Pessoa;
import br.com.jpautil.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(entidade);

		entityTransaction.commit();
		entityManager.close();
	}

	public Pessoa merge(E entidade) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Pessoa retorno = (Pessoa) entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();

		return retorno;
	}

	public void delete(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.remove(entidade);

		entityTransaction.commit();
		entityManager.close();

	}
	

	public void deleteId(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getId(entidade);
		entityManager.createQuery("delete from "+entidade.getClass().getCanonicalName() +" where id = "+id).executeUpdate();

		entityTransaction.commit();
		entityManager.close();
		
	}
	
	public List<E> getListPessoa(Class<E> entidade){
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	
		List<E> listaPessoaRetorno = entityManager.createQuery("from "+entidade.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return listaPessoaRetorno;
	}

}
