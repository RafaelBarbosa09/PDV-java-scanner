package controle_de_estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IProduto{

	List<Produto> listaDeProdutos = new ArrayList<Produto>();
	List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
	List<Produto> listaProdutosEmVenda = new ArrayList<Produto>();
	
	public static void cadastraProduto(){
		
		Produto novoProduto = new Produto();
		Categoria novaCategoria = new Categoria();
		
		Scanner sc = new Scanner(System.in);
		
		char opcao;
		
//		do{
			
		System.out.println("---------------CADASTRO DE PRODUTO---------------");
		
		System.out.println("Informe a categoria do produto: ");
		novaCategoria.setNomeDaCategoria(sc.nextLine());
		
		System.out.println("Informe o código do produto: ");
		novoProduto.setCodigoDoProduto(sc.nextLine());
		
		System.out.println("Informe a descrição do produto: ");
		novoProduto.setDescricaoDoProduto(sc.nextLine());
		
		System.out.println("Informe o preço do produto: ");
		novoProduto.setPreco(sc.nextDouble());
		
		listaDeProdutos.add(novoProduto);
		listaDeCategorias.add(novaCategoria);	
		
		novoProduto.setIdDoProduto(listaDeProdutos.indexOf(novoProduto) + 1);
		
		novoProduto.setCategoria(novaCategoria);
		
		System.out.println("produto cadastrado com sucesso!");
		
		for (Produto produto : listaDeProdutos) {
			System.out.println(produto.getDescricaoDoProduto());
		}
		
//		System.out.println("Deseja continuar ? s/n");
//		opcao = sc.next().charAt(0);
//		
//		sc.nextLine();
//		
//		}while(opcao == 's');
		
	}
	
	public static void pesquisaProdutoPelo(String codigo){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o código do produto: ");
		String pesquisaCodigoDoProduto = sc.nextLine();
		
		for (Produto produto : listaDeProdutos) {
			
			if(pesquisaCodigoDoProduto.equals(produto.getCodigoDoProduto())){
				System.out.println("\n---------PRODUTO PESQUISADO---------");
				System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
				System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
				System.out.println("Preço: R$ " + produto.getPreco());
				System.out.println("------------------------------------\n");
			}	
		}
	}
	
	public static void pesquisaProdutoPelaCategoria(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o nome da categoria: ");
		String novaCategoria = sc.nextLine();
		System.out.println("\n---------PRODUTO POR GATEGORIA---------\n");
		for (Produto produto : listaDeProdutos) {
			if(novaCategoria.equals(produto.getCategoria().getNomeDaCategoria())){
				System.out.println("Categoria Pesquisada: " + produto.getCategoria().getNomeDaCategoria());
				System.out.println("Código: " + produto.getCodigoDoProduto());
				System.out.println("Descrição: " + produto.getDescricaoDoProduto());
				System.out.println("Preço: R$ " + produto.getPreco());
				System.out.println("---------------------------------------");
			}
		}
	}
	
	public static void editarProduto(){
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Informe o código do produto que deseja editar: ");
		String editaProduto = sc.nextLine();
		
		for (Produto produto : listaDeProdutos) {
			if(editaProduto.equals(produto.getCodigoDoProduto())){
				System.out.println("O que deseja editar ?");
				System.out.println("1 - nome");
				System.out.println("2 - categoria");
				System.out.println("3 - preço");
				opcao = sc.nextInt();
				
				sc.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.println("\n--------------PRODUTO--------------");
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.println("Digite o novo nome: ");
					String novoNome = sc.nextLine();
					produto.setDescricaoDoProduto(novoNome);
					
					System.out.println("O nome foi editado com sucesso!");
					break;
				case 2:
					System.out.println("\n--------------PRODUTO--------------");
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.println("Informe a nova categoria: ");
					String novaCategoria = sc.nextLine();
					produto.getCategoria().setNomeDaCategoria(novaCategoria);
					
					System.out.println("O nome foi editado com sucesso!");
					break;
				case 3:
					System.out.println("\n--------------PRODUTO--------------");
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.println("Informe o novo valor do produto: ");
					double novoPreco = sc.nextDouble();
					produto.setPreco(novoPreco);
					
					System.out.println("O nome foi editado com sucesso!");
					break;
				default:
					break;
				}
			}
		}	
	}
	 
	public static void iniciaVendaNoPdv(){
		
		Scanner sc = new Scanner(System.in);
		char opcao;
		
		do{

			System.out.println("Código do produto: ");
			String produtoEmVenda = sc.nextLine();
			
			for (Produto produto : listaDeProdutos) {
				if(produtoEmVenda.equals(produto.getCodigoDoProduto())){
					produto.setQuantidade(1);
					listaProdutosEmVenda.add(produto);
					System.out.println("Produto: " + produto.getDescricaoDoProduto());
					System.out.println("Quantidade: " + produto.getQuantidade());
					System.out.println("Preço: " + produto.getPreco());
				}
			}
			
			System.out.println("Deseja continuar ? s/n");
			opcao = sc.next().charAt(0);
			
			sc.nextLine();
			
		}while(opcao == 's');
	}
	
	public static void listaCompras(){   //ainda não está pronto
		System.out.println();
		System.out.println("----------------------------ITENS VENDIDOS---------------------------");
		System.out.println("QTD.        CÓDIGO      DESCRIÇÃO          UNIT(R$)         TOTAL(R$)");
		
		double soma = 0;
		
		for (Produto produto : listaProdutosEmVenda) {
			
			double totalDoProduto = produto.getPreco() * produto.getQuantidade();
			
			System.out.print(produto.getQuantidade());
			System.out.print("           " + produto.getCodigoDoProduto());
			System.out.print("          " + produto.getDescricaoDoProduto());
			System.out.print("            " + produto.getPreco());
			System.out.println("            " + totalDoProduto);
		}

			System.out.println("---------------------------------------------------------------------");
			System.out.println("TOTAL:                                                           " + soma);
			System.out.println("---------------------------------------------------------------------");
			System.out.println();
			
	}	
}






//public static void totalDasCompras(){
//double somaTotal = 0;
//for (Produto produto : listaDeProdutos) {
//	for(int i = 0; i < listaDeProdutos.size(); i++){
//		somaTotal += produto.getPreco();
//	}
//}
//}


//System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria());


//do{
//System.out.print("Digite o código do produto: ");
//String pesquisaCodigoDoProduto = sc.nextLine();
//
//if(pesquisaCodigoDoProduto.equals(produto.getCodigoDoProduto())){
//	System.out.println(produto.getDescricaoDoProduto());
//}	
//
//System.out.println("Deseja continuar?");
//System.out.println("1 - Sim");
//System.out.println("2 - Não");
//opcao = sc.nextInt();
//
//}while(opcao != 2);

