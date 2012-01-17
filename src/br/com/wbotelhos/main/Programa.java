package br.com.wbotelhos.main;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.wbotelhos.helper.HibernateHelper;
import br.com.wbotelhos.helper.JPAHelper;
import br.com.wbotelhos.model.Empresa;
import br.com.wbotelhos.model.EmpresaUsuario;
import br.com.wbotelhos.model.EmpresaUsuarioId;
import br.com.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2012/01/17/hibernate-relacionamento-manytomany-com-atributos-e-chave-composta
 */

public class Programa {

	public static void main(String[] args) {
		// Helper do jIntegrity para criar as tabelas.
		HibernateHelper.exportSchema();

		// Helper do jIntegrity para pegar a conexao da JPA.
		EntityManager manager = JPAHelper.getEntityManager();

		// Cria e salva a empresa 1.
		Empresa empresa = new Empresa();
		empresa.setNome("Concrete Solutions");
		empresa = manager.merge(empresa);

		// Cria e salva o usuario 1.
		Usuario usuario = new Usuario();
		usuario.setUsername("wbotelhos");
		usuario = manager.merge(usuario);

		// Seta o usuario e a empresa salva na chave composta.
		EmpresaUsuarioId id = new EmpresaUsuarioId();
		id.setEmpresa(empresa);
		id.setUsuario(usuario);

		// Popula os dados da tabela intermediaria junto com a chave composta ja alimentada.
		EmpresaUsuario empresaUsuario = new EmpresaUsuario();
		empresaUsuario.setDataCadastro(new Date());
		empresaUsuario.setId(id);

		// Salva os dados da tabela intermediaria.
		manager.merge(empresaUsuario);

		// Helper do jIntegrity commitar e fechar a conexao da JPA.
		JPAHelper.close();
	}

}
