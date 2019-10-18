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
		
		System.out.println("---------------CADASTRO DE PRODUTO---------------");
		
		System.out.println("Informe a categoria do produto: ");
		novaCategoria.setNomeDaCategoria(sc.nextLine());
		
		System.out.println("Informe o c�digo do produto: ");
		novoProduto.setCodigoDoProduto(sc.nextLine());
		
		System.out.println("Informe a descri��o do produto: ");
		novoProduto.setDescricaoDoProduto(sc.nextLine());
		
		System.out.println("Informe o pre�o do produto: ");
		novoProduto.setPreco(sc.nextDouble());
		
		listaDeProdutos.add(novoProduto);
		listaDeCategorias.add(novaCategoria);	
		
		novoProduto.setIdDoProduto(listaDeProdutos.indexOf(novoProduto) + 1);
		novaCategoria.setCodigoDaCategoria(listaDeCategorias.indexOf(novaCategoria) + 1);
		
		novoProduto.setCategoria(novaCategoria);
		
		System.out.println("produto cadastrado com sucesso!");
		//listaCompras();

	}
	
	public static void pesquisaProdutoPelo(String codigo){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o c�digo do produto: ");
		String pesquisaCodigoDoProduto = sc.nextLine();
		
		for (Produto produto : listaDeProdutos) {
			
			if(pesquisaCodigoDoProduto.equals(produto.getCodigoDoProduto())){
				System.out.println("\n---------PRODUTO PESQUISADO---------");
				System.out.println("Categoria: " + produto.getCategoria().getCodigoDaCategoria() + " - " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
				System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
				System.out.println("------------------------------------\n");
			}	
		}
	}
	
	public static void iniciaVendaNoPdv(){
		
		Scanner sc = new Scanner(System.in);
		char opcao;
		
		do{

			System.out.println("C�digo do produto: ");
			String produtoEmVenda = sc.nextLine();
			
			for (Produto produto : listaDeProdutos) {
				if(produtoEmVenda.equals(produto.getCodigoDoProduto())){
					listaProdutosEmVenda.add(produto);
					System.out.println("Produto: " + produto.getDescricaoDoProduto());
					System.out.println("Pre�o: " + produto.getPreco());
				}
			}
			
			System.out.println("Deseja continuar ? s/n");
			opcao = sc.next().charAt(0);
			
		}while(opcao == 's');
	}
	
	
	public static void pesquisaProdutoPelaCategoria(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o nome da categoria: ");
		String novaCategoria = sc.nextLine();
		System.out.println("\n---------PRODUTO POR GATEGORIA---------\n");
		for (Produto produto : listaDeProdutos) {
			if(novaCategoria.equals(produto.getCategoria().getNomeDaCategoria())){
				System.out.println("Categoria Pesquisada: " + produto.getCategoria().getNomeDaCategoria());
				System.out.println(produto.getCodigoDoProduto());
				System.out.println(produto.getDescricaoDoProduto());
				System.out.println(produto.getPreco());
				System.out.println("---------------------------------------");
			}
		}
	}
	
	public static void editarProduto(){
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Informe o c�digo do produto que deseja editar: ");
		String editaProduto = sc.nextLine();
		
		for (Produto produto : listaDeProdutos) {
			if(editaProduto.equals(produto.getCodigoDoProduto())){
				System.out.println("O que deseja editar ?");
				System.out.println("1 - nome");
				System.out.println("2 - categoria");
				System.out.println("3 - pre�o");
				
				switch (opcao) {
				case 1:
					System.out.println("Digite o novo nome: ");
					String novoNome = sc.nextLine();
					produto.setDescricaoDoProduto(novoNome);
					break;
				case 2:
					System.out.println("Informe a nova categoria: ");
					String novaCategoria = sc.nextLine();
					produto.getCategoria().setNomeDaCategoria(novaCategoria);
					break;
				case 3:
					System.out.println("Informe o novo valor do produto: ");
					double novoPreco = sc.nextDouble();
					produto.setPreco(novoPreco);
					break;
				default:
					break;
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void listaCompras(){
		System.out.println();
		System.out.println("--------------------------ITENS VENDIDOS-------------------------");
		System.out.println("QTD.       C�DIGO     DESCRI��O         UNIT(R$)        TOTAL(R$)");
		
		double soma = 0;
		
		for (Produto produto : listaDeProdutos) {
			
			double totalDoProduto = produto.getPreco() * produto.getQuantidade();
			
			System.out.print(produto.getQuantidade());
			System.out.print("          " + produto.getIdDoProduto());
			System.out.print("          "+ produto.getDescricaoDoProduto());
			System.out.print("            " + produto.getPreco());
			System.out.println("            " + totalDoProduto);
		}

			System.out.println("-----------------------------------------------------------------");
			System.out.println("TOTAL:                                                           " + soma);
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			
	}	
		
//	public static void totalDasCompras(){
//		double somaTotal = 0;
//		for (Produto produto : listaDeProdutos) {
//			for(int i = 0; i < listaDeProdutos.size(); i++){
//				somaTotal += produto.getPreco();
//			}
//		}
//	}
}
	//System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria());


//do{
//System.out.print("Digite o c�digo do produto: ");
//String pesquisaCodigoDoProduto = sc.nextLine();
//
//if(pesquisaCodigoDoProduto.equals(produto.getCodigoDoProduto())){
//	System.out.println(produto.getDescricaoDoProduto());
//}	
//
//System.out.println("Deseja continuar?");
//System.out.println("1 - Sim");
//System.out.println("2 - N�o");
//opcao = sc.nextInt();
//
//}while(opcao != 2);

