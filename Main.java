/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinaryTree arvore = new BinaryTree();
		String expInfixa = "";
		List <String> expPosfixa = new ArrayList<>();
		
		int opcao = 0;
		do {
			System.out.println("Menu de opções:");
			System.out.println("1. Entrada da expressão na notação infixa.");
			System.out.println("2. Criação da árvore binária de expressão aritmética.");
			System.out.println("3. Exibição da árvore binária de expressão aritmética.");
			System.out.println("4. Cálculo da expressão.");
			System.out.println("5. Encerrar programa");
			System.out.println("Digite uma opção: ");	
			
			opcao = scanner.nextInt();
			switch(opcao) {
			case 1: 
				System.out.print("Digite a expressão infixa: ");
				scanner.nextLine(); //Consumir a quebra de linha pendente
				expInfixa = scanner.nextLine();
				if (isValidExpression(expInfixa)) {
					
					//converte a expressao infixa em posfixa
					expPosfixa = infixaPosfixa(expInfixa);
					System.out.println("Expressao valida!\n");
				}
				else {
					System.out.println("Expressao invalida!\n");
				}
				break;
			case 2:
				System.out.println(expPosfixa);
				arvore.buildExpressionTree(expPosfixa);
				System.out.println("Arvore criada!");
				break;
			case 3:
				System.out.println("Arvore em Pre-Ordem:");
				System.out.println(arvore.preOrderTraversal());
				System.out.println("Arvore em Ordem: ");
				System.out.println(arvore.inOrderTraversal());
				System.out.println("Arvore em Pos-Ordem:");
				System.out.println(arvore.postOrderTraversal());
				break;
			case 4:
				float result = arvore.calculo();
				System.out.println("Resultado do calculo da expressao: " + result);
				break;
			case 5:
				System.out.println("Encerrando o programa.");
				scanner.close();
			} //fim do switch case
		} while (opcao != 5);	
	}
	
	public static boolean isValidExpression(String expressao) {
		VeryBasicTokenizer vbt = new VeryBasicTokenizer(expressao);
		List <String> tokens = vbt.tokenize();	
		//boolean valida = true;	
		int contAbre = 0;
		int contFecha = 0;
		
		for (int i =0; i<tokens.size();i++) {
			
			if (tokens.get(i).equals("F"))
				return false;
			//System.out.println("token[" + i + " ]: "+ tokens.get(i));
			if (tokens.get(i).equals("("))
				contAbre++;
			else if (tokens.get(i).equals(")"))
				contFecha++;
			
			//Se parênteses for fechado sem que tenha sido aberto retorna false
			if (contFecha > contAbre) {
				System.out.print("Parênteses incorretos, expressão inválida.");
				return false;
			}
			if (tokens.get(i).equals("*") || tokens.get(i).equals("/")|| tokens.get(i).equals("+")|| tokens.get(i).equals("-") ){
				if (i+1 >= tokens.size())return false;
			
				else if (tokens.get(i+1).equals("*") || tokens.get(i+1).equals("/")|| tokens.get(i+1).equals("+")|| tokens.get(i+1).equals("-")) {
					if (tokens.get(i+1).equals("*") || tokens.get(i+1).equals("/")|| tokens.get(i+1).equals("+")|| tokens.get(i+1).equals("-"))return false;
				}
			}
			
		}
		if (contAbre != contFecha) return false;
		
		return true;
		}
	
	
	//Checam se determinada string eh Operador ou Operando
	public static boolean isOperator(String s) {
		return s == "+" || s == "-" || s == "*" || s == "/";
	}
	
	public static boolean isOperand(String s) {
		 for (char c : s.toCharArray()) {
		        if (!Character.isDigit(c) && c != '.') {
		            return false;	//considera ponto como parte de operandos validos (numeros decimais)
		        }
		    }
		    return true;
		}
	
	
	
	
	public static List <String> infixaPosfixa(String expInfixa) {
		VeryBasicTokenizer vbt = new VeryBasicTokenizer(expInfixa);
		List <String> tokens = vbt.tokenize();
		List <String> posfixa = new ArrayList<>();
		
		Stack<String> stackOperador = new Stack<>();
		
		
		for (int i =0; i<tokens.size();i++) {
			if (isOperand(tokens.get(i))) {
				//Se o token eh um operando, adicionamos ao resultado
				posfixa.add(tokens.get(i));
			}
			else if (isOperator(tokens.get(i))) {
				//Se for operador, tratamos a precedencia dos operadores
				while (!stackOperador.isEmpty() && precedencia(tokens.get(i)) <= precedencia(stackOperador.peek())) {
					posfixa.add(stackOperador.pop());
				}
				stackOperador.push(tokens.get(i));
			}
			else if(tokens.get(i) == "(") {
				//Se o token eh um parentese aberto, empilhamos na pilha
				stackOperador.push(tokens.get(i));
			}
			else if(tokens.get(i).equals(")")) {
				//Se o token for um parentese fechado, desempilhamos operadores ate encontrar o parentese aberto correspondente
				while (!stackOperador.isEmpty() && !stackOperador.peek().equals("(")) {
					posfixa.add(stackOperador.pop());
				}
				if(!stackOperador.isEmpty() && stackOperador.peek().equals("(")) {
					stackOperador.pop(); //remove o parentese aberto da pilha
				}

			}
		}
		
		//Desempilhamos os operadores restantes
		while (!stackOperador.isEmpty()) {
			posfixa.add(stackOperador.pop());
		}
	
		return posfixa;
		
		}
		
 //fim da funcao infixaPosfixa
	
	private static int precedencia(String operator) {
		switch (operator) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		default:
			return 0; //operando ou parentese
		}
	}

}//fim da Main

