package br.com.wbotelhos.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2012/01/17/hibernate-relacionamento-manytomany-com-atributos-e-chave-composta
 */

@Entity
public class EmpresaUsuario {

	@EmbeddedId
	private EmpresaUsuarioId id;

	private Date dataCadastro;

	public EmpresaUsuarioId getId() {
		return id;
	}

	public void setId(EmpresaUsuarioId id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
