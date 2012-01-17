package br.com.wbotelhos.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2012/01/17/hibernate-relacionamento-manytomany-com-atributos-e-chave-composta
 */

@Embeddable
public class EmpresaUsuarioId implements Serializable {

	private static final long serialVersionUID = 4671531966792866602L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaUsuarioId other = (EmpresaUsuarioId) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
