package br.com.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;

	static {

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("projetojsf");
		}
	}

	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getId(Object entidade) {
		return factory.getPersistenceUnitUtil().getIdentifier(entidade);
	}
}
