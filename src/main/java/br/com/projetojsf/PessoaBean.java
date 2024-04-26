package br.com.projetojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PostLoad;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoaLista = new ArrayList<Pessoa>();
	
	public String salvar() {
		
	//	daoGeneric.salvar(pessoa);
		pessoa = daoGeneric.merge(pessoa);
		carregarPessoa();
		return"";
	}

	public String novo() {
		pessoa = new Pessoa();
		return"";
	}
	
	public String deletar() {
		daoGeneric.deleteId(pessoa);
		pessoa = new Pessoa();
		carregarPessoa();
		return"";
	}
	
	public String editar(Pessoa pessoa) {
	   
	    this.pessoa = pessoa;
	    return "";
	}

	@PostConstruct
	public void carregarPessoa() {
		pessoaLista = daoGeneric.getListPessoa(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoaLista() {
		return pessoaLista;
	}

	public void setPessoaLista(List<Pessoa> pessoaLista) {
		this.pessoaLista = pessoaLista;
	}
}
