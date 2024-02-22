package myShoppingList1;

import java.util.Scanner;

public class MyShoppingList1 {

	public static void main(String[] args) {

		//20231493	Ewerton Becker Maciel Silva 	curso:LEI Turma 2
		//20220896	Tomás Aurélio Abelho dos Santos 	curso:LEI Turma 2

		int tamMax=100;

		String [] nome = new String[tamMax];
		double [] quanto = new double[tamMax];
		double [] preco = new double[tamMax];
		boolean [] feito = new boolean[tamMax];

		int nItens=0;

		Scanner input = new Scanner(System.in);

		char opPrincipal = 0;
		char opEditar = 0;
		char opFazerCompras = 0;
		char opListar = 0;
		char opContas = 0;

		do{

			//Menu principal

			System.out.println("MyShoppingList 1.0\n");

			System.out.println("(E)ditar Lista.\n"
					+ "(F)azer compras.\n"
					+ " Fazer (c)ontas.\n"
					+ "(S)air.\n"
					+ "\nIntroduza um caracter para interagir com o menu:");

			opPrincipal = input.next().charAt(0);
			input.nextLine(); // Consumir a quebra de linha pendente depois do input do utilizador

			// 1ª escolha (Editar, Compras ou Contas) 

			switch(opPrincipal){

			//Escolha editar

			case 'E': case 'e':

				do{
					// menu da opção de editar lista

					System.out.println("(I)nserir item no fim da lista.\n"
							+ "Inserir item na (p)osição n da lista.\n"
							+ "Apagar (ú)ltimo item inserido na lista.\n"
							+ "Apagar item na posição (n) da lista.\n"
							+ "(A)pagar itens da posição m à n da lista.\n"
							+ "(L)istar todos os itens.\n"
							+ "(V)oltar.\n"
							+ "\nIntroduza um caracter para interagir com o menu:");

					opEditar = input.next().charAt(0); 
					input.nextLine();

					//Sub-menus da opção editar

					switch(opEditar){

					//Funcionalidade "Introduzir Item no fim da lista"

					case 'I': case 'i':

						System.out.print("\nIndique o item que quer adicionar: ");
						nome[nItens] = input.next();
						input.nextLine();

						System.out.print("\nIndique a quantidade do Item:");
						quanto[nItens] = input.nextDouble();
						input.nextLine();

						System.out.print("\nIndique o preço do Item:");
						preco[nItens]= input.nextDouble();
						input.nextLine();
						nItens++;

						System.out.println("\nItem adicionado com sucesso!");
						System.out.println();

						break;

						//Funcionalidade "Introduzir item numa posição escolhida pelo user que já esteja ocupada" 

					case 'p': case 'P': 

						//Condição que verifica se a lista contem itens 

						if (nItens>0){

							System.out.println("Introduza a posição onde deseja colocar o item:");

							int posicaoItemNovo = input.nextInt();

							if (posicaoItemNovo<nItens && posicaoItemNovo>=0) {

								//move itens para a direita para arranjar espaço para o item novo

								for (int i = nItens; i > posicaoItemNovo ; i--) {

									nome[i]= nome[i-1];
									quanto[i] = quanto[i-1];
									preco[i] = preco[i-1];
								}

								System.out.println("Introduza o nome do item que prentede adicionar:");
								String nomeNovoItem = input.next();
								input.nextLine();

								System.out.println("Introduza a quantidade do item que prentede adicionar:");
								double quantidadeNovoItem = input.nextDouble();
								input.nextLine();

								System.out.println("Introduza o preço do item que prentede adicionar:");
								double precoNovoItem = input.nextDouble();
								input.nextLine();

								//Coloca todos o parametros do item nas posições respetivas do array

								nome[posicaoItemNovo]= nomeNovoItem;
								quanto[posicaoItemNovo] = quantidadeNovoItem;
								preco[posicaoItemNovo] = precoNovoItem;

								nItens++;

								System.out.printf("Item adicionado com sucesso à posição %d!",posicaoItemNovo);


							} else {

								System.out.println("A posição introduzida é inválida!");
							}


						} else {

							System.out.println("\nA lista está vazia. Não existem posições para ocupar!");

						}

						System.out.println();

						break;

						//Funcionalidade "Apagar o item da ultima posição"

					case 'U': case 'u': case 'ú': case 'Ú':

						if(nItens > 0) {

							//mete todos os valores do último item vazios dentro do respetivo array

							nome[nItens-1] = "";

							preco[nItens - 1] = 0;

							quanto[nItens - 1] = 0;

							feito[nItens - 1] = false;

							nItens--;

							System.out.println("\nÚltimo item removido com sucesso!");

						} else {

							System.out.println("\nA lista está vazia. Não tem items para remover!");

						}

						System.out.println();

						break;

						//Funcionalidade "Apagar um item de uma posição escolhida pelo user"

					case 'N': case 'n':

						if (nItens>0) {

							System.out.println("\nEscolha uma posição para apagar um item:");
							int posicaoApagar = input.nextInt();
							input.nextLine();
							
							if (posicaoApagar >= 0 && posicaoApagar < nItens) {
							    
								// Move todos os itens à direita do item a ser apagado para a esquerda
								
							    for (int i = posicaoApagar; i < nItens - 1; i++) {
							        nome[i] = nome[i + 1];
							        quanto[i] = quanto[i + 1];
							        preco[i] = preco[i + 1];
							        feito[i] = feito[i + 1];
							    }
							   
							    nItens--;

							    System.out.println("\nItem apagado com sucesso!");
							} else {
							    System.out.println("\nPosição inválida! Não é possível apagar itens.");
							}
							
						} else System.out.println("\nA lista está vazia. Não tem items para remover!");

						System.out.println();

						break;

						//Funcionalidade "Apagar itens de uma posição inicial até uma posição final, escolhidas pelo user"

					case 'A': case 'a':

						if (nItens>0) {

							System.out.println("Introduza a posição inicial (m): ");
							int posicaoInicial = input.nextInt();
							input.nextLine();

							System.out.println("Introduza a posição final (n): ");
							int posicaoFinal = input.nextInt();
							input.nextLine();

							// Confirma que as posições são válidas

							if (posicaoInicial >= 0 && posicaoFinal <= nItens && posicaoInicial <= posicaoFinal) {

								// Calcula o número de itens a serem removidos

								int itensRemover = posicaoFinal - posicaoInicial + 1;

								// Move os itens após a posição final para trás para ocupar os espaços deixados pelos itens anteriores

								for (int i = posicaoFinal + 1; i <= nItens; i++) {

									nome[i - itensRemover] = nome[i];
									preco[i - itensRemover] = preco[i];
									quanto[i - itensRemover] = quanto[i];
									feito[i - itensRemover] = feito[i];
								}

								// Atualiza nItens para o número de posições do array atualizado

								nItens -= itensRemover;

								System.out.println("Itens removidos com sucesso!");

							} else {

								System.out.println("Posições inválidas! Tente novamente.");

							}

						} else {

							System.out.println("\nA lista está vazia. Não tem items para remover!");

						}

						System.out.println();

						break;

						//Funcionalidade de listar todos os itens da lista

					case 'L': case 'l':

						if(nItens>0) {

							System.out.println("\nLista de Itens:\n");

							System.out.printf("%-5s %-20s %-15s %-10s %-10s\n", "Item", "Nome", "Quantidade", "Preço", "Comprado");

							System.out.println();

							//ciclo que lista itens

							for (int i = 0; i < nItens; i++) { 
								String statusComprado = feito[i] ? "X" : " ";
								System.out.printf("%-5d %-20s %-15.3f %-10.2f %-10s\n", (i), nome[i], quanto[i], preco[i], statusComprado);

							}

						} else { 

							System.out.println("A lista está vazia! Introduza itens!");

						}

						System.out.println();

						break;

						//volta para o menu anterior

					case 'V': case 'v':

						break;

					default:

						System.out.print("Caracter introduzido inválido. Por favor tente novamente.");

						System.out.println();

					}

				} while(opEditar != 'V' && opEditar !='v');

				break;

				// menu da opção fazer compras

			case 'F':case 'f':

				do{

					System.out.println("(M)arcar primeiro item por comprar.\n"
							+ "(D)esmarcar primeiro item comprado.\n"
							+ "Trocar estado por (n)ome.\n"
							+ "Trocar estado por (p)osição.\n"
							+ "(L)istar.\n"
							+ "(V)oltar.\n"
							+ "Introduza um caracter para interagir com o menu:");

					System.out.println();

					opFazerCompras=input.next().charAt(0);

					//Sub-menus da opção fazer compras

					switch(opFazerCompras){

					//Funcionalidade "marcar o primeiro item por comprar"

					case 'M': case 'm':

						boolean itemEncontrado = false;

						if (nItens>0) {

							for (int i = 0; i<nItens; i++) {

								if (!feito[i]) {

									feito[i]=true;
									System.out.println("O primeiro item está por comprar!");

									itemEncontrado = true;

									break;
								} 	
							}

							//caso a variável "desmarcar" não mude o seu valor temos a mensagem de aviso

							if(!itemEncontrado) {
								System.out.println("\nNenhum item comprado para desmarcar!");
							}
						} else {

							System.out.println("\nA lista está vazia!");

						}

						System.out.println();

						break;

						//Funcionalidade "desmarcar o primeiro item marcado"

					case 'D': case 'd':

						boolean desmarcar = false;

						if (nItens>0) {

							//ciclo que verifica qual o primeiro item marcado e desmarca o 

							for(int i = 0; i < nItens; i++){

								if (feito[i]) {

									feito[i] = false;
									System.out.println("\nPrimeiro item comprado desmarcado com sucesso!");

									desmarcar = true;

									break;	
								}
							}

							//caso a variável "desmarcar" não mude o seu valor temos a mensagem de aviso

							if (!desmarcar) {
								System.out.println("\nNenhum item comprado para desmarcar!");
							}
						} else {

							System.out.println("\nA lista está vazia!");

						}

						System.out.println();

						break;

						//Funcionalidade "alterar estado do item pelo nome"

					case 'N': case 'n':

						if (nItens>0) {

							System.out.print("Digite o nome do item que deseja alterar: ");
							String nomeItem = input.next();
							input.nextLine();

							boolean encontrou = false;

							for (int i = 0; i < nItens; i++) {
								if (nome[i].equalsIgnoreCase(nomeItem)) {

									feito[i] = !feito[i];  // Inverte o estado "comprado" do item na posição i onde encontrou o string desejado
									encontrou = true;

									System.out.println("Estado do item alterado com sucesso!");

									break;
								}
							}

							//caso a variável "encontrou" não mude o seu valor temos a mensagem de aviso

							if (!encontrou) {
								System.out.println("Erro! Item não encontrado na lista!");
							}
						} else {

							System.out.println("\nA lista está vazia!");

						}

						System.out.println();

						break;

						//Funcionalidade "alterar estado do item pela posição"

					case 'P': case 'p':

						if (nItens>0) {

							System.out.println("Escolha a posição do item para trocar o estado:");

							int posicaoTrocarEstado = input.nextInt();
							input.nextLine();

							if (posicaoTrocarEstado >= 0 && posicaoTrocarEstado <= nItens) {

								// Inverte o estado (comprado/não comprado) do item na posição escolhida

								feito[posicaoTrocarEstado] = !feito[posicaoTrocarEstado];
								System.out.println("Estado do item na posição " + posicaoTrocarEstado + " alterado com sucesso!");

							} else {
								System.out.println("Posição inválida! Tente novamente!");
							}
						} else {

							System.out.println("\nA lista está vazia!");

						}

						System.out.println();

						break;

						//case do sub-menu listar

					case 'L': case 'l':

						System.out.println("Listar (t)odos os itens.\n"
								+ "Listar itens (c)omprados.\n"
								+ "Listar itens (p)or comprar.\n"
								+ "Introduza um caracter para interagir com o menu:");

						System.out.println();

						opListar = input.next().charAt(0);

						//sub-menu listar

						switch(opListar){

						//Funcionalidade "Listar todos os itens"

						case 'T': case 't':

							if(nItens>0) {

								System.out.println("\nLista de Itens:\n");

								System.out.printf("%-5s %-20s %-15s %-10s %-10s\n", "Item", "Nome", "Quantidade", "Preço", "Comprado");

								System.out.println();

								for (int i = 0; i < nItens; i++) { //ciclo que lista itens
									String statusComprado = feito[i] ? "X" : " ";
									System.out.printf("%-5d: %-20s %-15.3f %-10.2f %-10s\n", (i), nome[i], quanto[i], preco[i], statusComprado);

								} 

								System.out.println();

							} else { 

								System.out.println("A lista está vazia!");

							}

							break;

							//Funcionalidade "Listar itens comprados"

						case 'C': case 'c':

							if (nItens > 0) {

								System.out.println("\nLista de Itens Comprados:\n");
								System.out.printf("%-5s %-20s %-15s %-10s\n", "Item", "Nome", "Quantidade", "Preço");
								System.out.println();

								for (int i = 0; i < nItens; i++) { //ciclo que lista itens 

									if (feito[i]==true) {

										System.out.printf("%-5d: %-20s %-15.3f %-10.2f\n", (i), nome[i], quanto[i], preco[i]);

									} else;
								}
							} else {

								System.out.println("A lista não contem Itens comprados! Vá às compras!");

							}

							System.out.println();

							break;

							//Funcionalidade "Listar itens por comprar"

						case 'P': case 'p':

							if (nItens > 0) {

								System.out.println("\nLista de Itens Por Comprar:\n");
								System.out.printf("%-5s %-20s %-15s %-10s\n", "Item", "Nome", "Quantidade", "Preço");
								System.out.println();

								for (int i = 0; i < nItens; i++) { //ciclo que lista itens 

									if (feito[i]==false) {

										System.out.printf("%-5d: %-20s %-15.3f %-10.2f\n", (i), nome[i], quanto[i], preco[i]);

									} else;
								}

							} else {
								System.out.println("A lista não contem Itens por comprar! Já comprou tudo!");
							}
						}

						System.out.println();

						break;

						//Funcionalidade "voltar"

					case 'V': case 'v':

						break;
					}

				}while(opFazerCompras != 'V' && opFazerCompras != 'v');

				break;

				//Menu Fazer Contas

			case 'C': case'c':

				do {

					System.out.println("\nQuanto custa a (l)ista?\n"
							+ "Quanto já (g)astei?\n"
							+ "Quanto custa o que (f)alta comprar?\n"
							+ "Qual o preço (m)édio por item?\n"
							+ "(V)oltar\n"
							+ "\nIntroduza um caracter para interagir com o menu:");

					System.out.println();

					opContas = input.next().charAt(0);

					//sub-menus Fazer Contas

					switch(opContas){

					//Funcionalidade "Calcular custo total da lista"

					case 'L': case 'l':

						double custoTotal = 0;

						// Calcular o custo total somando os preços de todos os itens

						for (int i = 0; i < nItens; i++) {
							custoTotal += preco[i] * quanto[i];
						}

						System.out.printf("O custo total da lista é: %.2f€\n", custoTotal);
						System.out.println();


						break;

						//Funcionalidade "Calcular quanto já gastei"

					case 'G': case 'g':

						double quantoJaGastei =0;

						//Ciclo para calcular o custo de itens já comprados

						for (int i = 0; i < nItens; i++) {

							if (feito[i]) {

								quantoJaGastei += preco[i] * quanto[i];

							}
						}

						System.out.printf("Já gastou: %.2f€\n", quantoJaGastei);
						System.out.println();

						quantoJaGastei =0;

						break;

						//Funcionalidade "O que falta comprar"

					case 'F': case 'f':

						double quantoCustaOQueFalta =0;

						//Ciclo para calcular o custo de itens já comprados

						for (int i = 0; i < nItens; i++) {

							if (!feito[i]) {

								quantoCustaOQueFalta += preco[i] * quanto[i];

							}
						}

						System.out.printf("O que falta comprar custa: %.2f€\n", quantoCustaOQueFalta);
						System.out.println();

						quantoCustaOQueFalta =0;

						break;

						//Funcionalidade "Calcular preço médio"

					case 'M': case 'm':

						double quantidadeTotal = 0;
						double precoMedio=0;

						if (nItens > 0) {

							// Calcular o preço médio dividindo o custo total pelo número de itens
							for (int i = 0; i < nItens; i++) {
								precoMedio += preco[i] * quanto[i];
								quantidadeTotal += quanto[i];
							}

							precoMedio = precoMedio / quantidadeTotal;

							System.out.printf("O preço médio por item é: %.2f€\n", precoMedio);
						} else {
							System.out.println("A lista está vazia. Não é possível calcular o preço médio.");

						}

						quantidadeTotal = 0;
						precoMedio=0;

						break;

					}


				} while (opContas != 'V' && opContas != 'v') ;

				break;

				//Opção para sair do programa

			case 'S': case 's':

				System.out.print("\nObrigado por nos visitar! UwU");

				break;

			default:

				//caso o utilizador escreva algo incorreto

				System.out.println("\nCaracter introduzido inválido. Por favor tente novamente.\n");
				break;
			}

		}while(opPrincipal!='S' && opPrincipal!='s' );

		input.close();

	}
}

