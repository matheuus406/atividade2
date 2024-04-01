package br.com.ma.DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.ma.Cliente;

public class clienteMapDAO implements IclienteDAO {
	
	private  Map<Long, Cliente> map;
	
	public clienteMapDAO () {
		this.map = new HashMap<>();
	};

	@Override
	public boolean cadastrar(Cliente cliente) {
		if (this.map.containsKey(cliente.getCpf())){
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		Cliente clienteCdastrado = this.map.get(cpf);
		if (clienteCdastrado != null) {
		this.map.remove(clienteCdastrado.getCpf(), clienteCdastrado);
		}
		
		
	}

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado= map.get(cliente.getCpf());
		if (clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setEstado(cliente.getEstado());
			clienteCadastrado.setEnd(cliente.getEnd());
			clienteCadastrado.setTelefone(cliente.getTelefone());
		}
	}

	@Override
	public Cliente consultar(Long cpf) {
		// TODO Auto-generated method stub
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.map.values();
	}

}
