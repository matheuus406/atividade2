package br.com.ma;


import javax.swing.JOptionPane;

import br.com.ma.DAO.IclienteDAO;
import br.com.ma.DAO.clienteMapDAO;


public class app {
	private static IclienteDAO iClienteDAO;

	public static void main(String args[]) {
		
		iClienteDAO = new clienteMapDAO();
		
		
		String opcao = JOptionPane.showInputDialog(null, "digite 1 para cadastro, digite 2 para consultar, digite 3 para exlusão, digite 4 para alteração, digite 5 para sair", "green dinner", JOptionPane.INFORMATION_MESSAGE);
		   
		   while(!opcaoInvalida(opcao)) {
			   if("".equals(opcao) ) {
				   sair();
			   }
				opcao = JOptionPane.showInputDialog(null, "OPÇÃO INVÁLIDA, Digite 1 para cadastro, digite 2 para consultar, digite 3 para exlusão, digite 4 para alteração, digite 5 para sair", "greeN DINNER", JOptionPane.INFORMATION_MESSAGE);
			}
		    while(opcaoInvalida(opcao)) {
		    	if (opcaoSair(opcao)){
		    		sair();
		    	} else if (inCadastro(opcao)) {
		    		String dados = JOptionPane.showInputDialog(null, "Informe os dados como o exemplo -> nome, cpf, telefone, endereço,numero,cidade,estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
		    	cadastro(dados)	;		
		    		
		    	} else if (insConsultar(opcao)) {
		    		String dados = JOptionPane.showInputDialog(null, "Informe o CPF: ", "Consultar", JOptionPane.INFORMATION_MESSAGE);
			    	consultar(dados);
		    		
		    	} else if (inExclusao(opcao)) {
		    		String dados = JOptionPane.showInputDialog(null, "Informe o CPF: ", "Excluir", JOptionPane.INFORMATION_MESSAGE);
		    	exclusao(dados);
			    	
			    } else  {
			    	 String dados = JOptionPane.showInputDialog(null,
		                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
		                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
			    	alterar(dados);
			    	
			    	
			    }
		    	opcao = JOptionPane.showInputDialog(null, "digite 1 para cadastro, digite 2 para consultar, digite 3 para exlusão, digite 4 para alteração, digite 5 para sair", "green dinner", JOptionPane.INFORMATION_MESSAGE);	

		    } 

		   
	   }
	

	private static void alterar(String dados) {
		 String[] dadosSeparados = dados.split(",");
	        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
	        iClienteDAO.alterar(cliente);
	}
	

	
	


	private static void exclusao(String dados) {
		iClienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
	
	}


	private static boolean inExclusao(String opcao) {
		if ("3".equals(opcao)) {
			return true;
		}
		return false;
	}


	private static void consultar(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if (cliente != null) {
			JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} else JOptionPane.showMessageDialog(null, "Cliente não encontrado: " , "Error",JOptionPane.INFORMATION_MESSAGE);
		
	}
	private static boolean insConsultar(String opcao) {
		if ("2".equals(opcao)) {
			return true;
		}
		return false;
	}


	private static void cadastro(String dados) {
 
		String[] dados2 = dados.split(",");	
		Cliente cliente = new Cliente(dados2[0],dados2[1],dados2[2],dados2[3],dados2[4],dados2[5],dados2[6]);
		boolean isCadastrado = iClienteDAO.cadastrar(cliente);
		if(isCadastrado) {
			JOptionPane.showConfirmDialog(null, "Cliente Cadastrado com sucesso", "sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} else JOptionPane.showConfirmDialog(null, "Cliente ja se Encontra  Cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
	}


	private static boolean inCadastro(String opcao) {
		if("1".equals(opcao)) {
			return true;
		}
		return false;
	}


	private static boolean opcaoSair(String opcao) {
		if("5".equals(opcao)) {
			return true;
		}
		return false;
	}


	private static void sair() {
		JOptionPane.showConfirmDialog(null, "Até logo", "sair", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private static boolean isOpcaoCadastro(String opcao) {
		if ("1".equals(opcao)) {
			return true;
		}
		
		return false;
	}

	private static boolean opcaoInvalida(String opcao) {
		if ("1".equals(opcao)||"2".equals(opcao)||"3".equals(opcao)||"4".equals(opcao)||"5".equals(opcao)) {
			return true;
			
		}
		
		return false;
	}

	
}
