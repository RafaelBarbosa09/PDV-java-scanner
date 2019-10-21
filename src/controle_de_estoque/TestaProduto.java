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
				ProdutoServiceImpl.cadastraProduto();
				break;
			case 2:
				ProdutoServiceImpl.pesquisaProdutoPelo(codigo);
				break;
			case 3:
				ProdutoServiceImpl.editarProduto();
				break;
			case 4:
				ProdutoServiceImpl.pesquisaProdutoPelaCategoria();
				
				break;
			case 5:
				ProdutoServiceImpl.iniciaVendaNoPdv();
				
				break;
			case 6:
				ProdutoServiceImpl.cancelaItem();
				break;
			case 7:
				ProdutoServiceImpl.cancelaCupom();
				break;
			case 8:
				ProdutoServiceImpl.listaCompras();
				break;
			default:
				System.out.println("Insira uma opção válida");
				break;
			}
		}while(opcao != 9);

	}
}
