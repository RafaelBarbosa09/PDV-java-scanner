package controle_de_estoque;

import java.util.Scanner;

public class TestaProduto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		String codigo = "";
		
		do{
			System.out.println("O que deseja fazer ?");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Pesquisar produto");
			System.out.println("3 - Editar produto");
			System.out.println("4 - Pesquisar por categoria");
			System.out.println("5 - Iniciar venda PDV");
			System.out.println("6 - Cancelar item");
			System.out.println("7 - Cancelar venda");
			System.out.println("8 - Cupom Fiscal");
			System.out.println("9 - Sair");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				IProduto.cadastraProduto();
				break;
			case 2:
				IProduto.pesquisaProdutoPelo(codigo);
				break;
			case 3:
				IProduto.editarProduto();
				break;
			case 4:
				IProduto.pesquisaProdutoPelaCategoria();
				
				break;
			case 5:
				IProduto.iniciaVendaNoPdv();
				
				break;
			case 6:
				System.out.println("cancelando Item");
				break;
			case 7:
				System.out.println("cancelando venda");
				break;
			case 8:
				IProduto.listaCompras();
				break;
			default:
				System.out.println("Insira uma opção válida");
				break;
			}
		}while(opcao != 8);

	}
}
