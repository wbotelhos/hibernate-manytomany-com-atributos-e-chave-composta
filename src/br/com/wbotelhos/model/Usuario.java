package br.com.wbotelhos.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2012/01/17/hibernate-relacionamento-manytomany-com-atributos-e-chave-composta
 */

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	@OneToMany(mappedBy = "id.usuario")
	private Collection<EmpresaUsuario> empresaUsuarioList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<EmpresaUsuario> getEmpresaUsuarioList() {
		return empresaUsuarioList;
	}

	public void setEmpresaUsuarioList(Collection<EmpresaUsuario> empresaUsuarioList) {
		this.empresaUsuarioList = empresaUsuarioList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
