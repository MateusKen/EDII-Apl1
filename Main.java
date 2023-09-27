/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/

import java.util.Scanner;
import java.util.Stack;


public class Main extends BTNode{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinaryTree arvore = new BinaryTree();
		String expInfixa = "";
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
					arvore.buildExpressionTree(expInfixa);
					System.out.println("Expressao valida!");
				}
				else {
					System.out.println("Expressao invalida!");
				}
				break;
			case 2:
				arvore.buildExpressionTree(expInfixa);
				System.out.println("Arvore criada!");
				break;
			case 3:
				System.out.println("Arvore em Pre-Ordem:");
				System.out.println(arvore.preOrderTraversal());
				System.out.println("Arvore em Ordem: ");
				System.out.println(arvore.inOrderTraversal());
				System.out.println("Arvire em Pos-Ordem:");
				System.out.println(arvore.postOrderTraversal());
				break;
			case 4:
				float result = arvore.visitar();
				System.out.println("Resultado do calculo da expressao: " + result);
				break;
			case 5:
				System.out.println("Encerrando o programa.");
				scanner.close();
			} //fim do switch case
		} while (opcao != 5);	
	}
	
	public static boolean isValidExpression(String expression) {
		Stack<Character> stack = new Stack<>();
		
		for (char ch : expression.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			}
			else if(ch == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false; // parenteses desbalanceados
				}
			}
			else if(!isOperator(ch) && !isOperand(ch)) {
				return false; // caracter invalido
			}
		}
		return stack.isEmpty();
	}
	
	public static String infixaPosfixa(String expInfixa) {
		StringBuilder posfixa = new StringBuilder();
		Stack<Character> stackOperador = new Stack<>();
		
		for (char token : expInfixa.toCharArray()) {
			if (isOperand(token)) {
				//Se o token eh um operando, adicionamos ao resultado
				posfixa.append(token);
			}
			else if (isOperator(token)) {
				//Se for operador, tratamos a precedencia dos operadores
				while (!stackOperador.isEmpty() && precedencia(token) <= precedencia(stackOperador.peek())) {
					posfixa.append(stackOperador.pop());
				}
				stackOperador.push(token);
			}
			else if(token == '(') {
				//Se o token eh um parentese aberto, empilhamos na pilha
				stackOperador.push(token);
			}
			else if(token == ')') {
				//Se o token for um parentese fechado, desempilhamos operadores ate encontrar o parentese aberto correspondente
				while (!stackOperador.isEmpty() && stackOperador.peek() != '(') {
					posfixa.append(stackOperador.pop());
				}
				if(!stackOperador.isEmpty() && stackOperador.peek() != '(') {
					stackOperador.pop(); //remove o parentese aberto da pilha
				}
				else {
					//parenteses desbalanceados
					return "Expressao infixa invalida";
				}
			}
		}
		//Desempilhamos os operadores restantes
		while (!stackOperador.isEmpty()) {
			if (stackOperador.peek() == '(' || stackOperador.peek() == ')') {
				//parenteses desbalanceados
				return "Expressao infixa invalida";
			}
			posfixa.append(stackOperador.pop());
		}
		return posfixa.toString();
} //fim da fun;'ao infixaPosfixa
	
	private static int precedencia(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0; //operando ou parentese
		}
	}

}//fim da Main
