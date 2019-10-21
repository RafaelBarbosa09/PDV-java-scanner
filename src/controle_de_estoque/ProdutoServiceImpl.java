package controle_de_estoque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProdutoServiceImpl {
	
	public static List<Produto> listaDeProdutos = new ArrayList<Produto>();
	public static List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
	public static List<Produto> listaProdutosEmVenda = new ArrayList<Produto>();
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cadastraProduto(){
		
		Produto novoProduto = new Produto();
		Categoria novaCategoria = new Categoria();
		
		char opcao;

		System.out.println("---------------CADASTRO DE PRODUTO---------------");
		
		System.out.println("Informe a categoria do produto: ");
		novaCategoria.setNomeDaCategoria(sc.nextLine());
		
		sc.nextLine();
		
		System.out.println("Informe o código do produto: ");
		novoProduto.setCodigoDoProduto(sc.nextLine());
		
		sc.nextLine();
		
		System.out.println("Informe a descrição do produto: ");
		novoProduto.setDescricaoDoProduto(sc.nextLine());
		
		sc.nextLine();
		
		System.out.println("Informe o preço do produto: ");
		novoProduto.setPreco(sc.nextDouble());
		
		sc.nextLine();
		
		listaDeProdutos.add(novoProduto);
		listaDeCategorias.add(novaCategoria);	
		
		novoProduto.setIdDoProduto(listaDeProdutos.indexOf(novoProduto) + 1);
		
		novoProduto.setCategoria(novaCategoria);
		
		System.out.println("produto cadastrado com sucesso!");
		System.out.println("");
	}
	
	public static void pesquisaProdutoPelo(String codigo){
		
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
		
		System.out.print("Informe o nome da categoria: ");
		String novaCategoria = sc.nextLine();
		System.out.println("\n---------PRODUTO POR GATEGORIA---------\n");
		for (Produto produto : listaDeProdutos) {
			if(novaCategoria.equals(produto.getCategoria().getNomeDaCategoria())){
				System.out.println("Categoria Pesquisada: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
				System.out.println("Código: " + produto.getCodigoDoProduto());
				System.out.println("Descrição: " + produto.getDescricaoDoProduto().toUpperCase());
				System.out.println("Preço: R$ " + produto.getPreco());
				System.out.println("---------------------------------------");
			}
		}
	}
	
	public static void editarProduto(){
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
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.print("Digite o novo nome: ");
					String novoNome = sc.nextLine();
					produto.setDescricaoDoProduto(novoNome);
					
					System.out.println("O nome foi editado com sucesso!");
					break;
				case 2:
					System.out.println("\n--------------PRODUTO--------------");
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.print("Informe a nova categoria: ");
					String novaCategoria = sc.nextLine();
					produto.getCategoria().setNomeDaCategoria(novaCategoria);
					
					System.out.println("A categoria foi editada com sucesso!");
					break;
				case 3:
					System.out.println("\n--------------PRODUTO--------------");
					System.out.println("Categoria: " + produto.getCategoria().getNomeDaCategoria().toUpperCase());
					System.out.println("Produto: " + produto.getCodigoDoProduto() + " - " + produto.getDescricaoDoProduto().toUpperCase());
					System.out.println("Preço: R$ " + produto.getPreco());
					System.out.println("------------------------------------\n");
					
					System.out.print("Informe o novo valor do produto: ");
					double novoPreco = sc.nextDouble();
					produto.setPreco(novoPreco);
					
					System.out.println("O valor foi editado com sucesso!");
					break;
				default:
					break;
				}
			}
		}	
	}
	
	public static void cancelaItem(){
		
		System.out.print("Informe o código do produto que deseja cancelar: ");
		String verificaProduto = sc.nextLine();
		
		sc.nextLine();
		
		listaProdutosEmVenda.forEach(System.out::println);
		
		
		
//		for (Produto produto : listaProdutosEmVenda) {
//			if(verificaProduto.equals(produto.getCodigoDoProduto())){
//				listaProdutosEmVenda.remove(produto);
//				System.out.println("Produto cancelado com sucesso!");
//			}
//		}
	}
	
	public static void cancelaCupom(){
		System.out.println("Deseja cancelar o cupom ?(s/n)");
		char opcao = sc.next().charAt(0);
		
		if(opcao == 's'){
			for (Produto produto : listaProdutosEmVenda) {
				listaProdutosEmVenda.clear();
			}
		}
	}
	 
	public static void iniciaVendaNoPdv(){
		
		char opcao;
		
		do{

			System.out.print("Código do produto: ");
			String produtoEmVenda = sc.nextLine();
			
			sc.nextLine();
			
			for (Produto produto : listaDeProdutos) {
				if(produtoEmVenda.equals(produto.getCodigoDoProduto())){
					produto.setQuantidade(1);
					listaProdutosEmVenda.add(produto);
					System.out.println("Produto: " + produto.getDescricaoDoProduto().toUpperCase());
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
		System.out.println("------------------------------ITENS VENDIDOS-----------------------------");
		System.out.println("QTD.        CÓDIGO          DESCRIÇÃO          UNIT(R$)         TOTAL(R$)");
		
		double soma = 0;
		
		for (Produto produto : listaProdutosEmVenda) {
			
			double totalDoProduto = produto.getPreco() * produto.getQuantidade();
			
			System.out.print(produto.getQuantidade());
			System.out.print("           " + produto.getCodigoDoProduto());
			System.out.print("            " + produto.getDescricaoDoProduto().toUpperCase());
			System.out.print("            " + produto.getPreco());
			System.out.println("            " + totalDoProduto);
		}

			System.out.println("-------------------------------------------------------------------------");
			System.out.println("TOTAL:                                                           " + soma);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println();
			
	}	
}
