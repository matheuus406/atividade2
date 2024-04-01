package br.com.ma.DAO;

import java.util.Collection;

import br.com.ma.Cliente;

public interface IclienteDAO {
	public boolean cadastrar (Cliente cliente);
	public void excluir(Long cpf);
	public  void alterar (Cliente cliente);
	public Cliente consultar(Long cpf);
	public Collection<Cliente> buscarTodos();

}
