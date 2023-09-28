/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/

import java.util.List;
import java.util.Stack;

public class BinaryTree {
	private BTNode root;
	public BinaryTree() {
		this(null);
	}
	public BinaryTree(BTNode root) {
		this.root = root;
	}
	
	public BTNode getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public static boolean isOperator(String s) {
		return s == "+" || s == "-" || s == "*" || s == "/";
	}
	
	
	//Percurso Em ordem
	public String inOrderTraversal() {
		return inOrderTraversalHelper(root);
	}
	private String inOrderTraversalHelper(BTNode node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(inOrderTraversalHelper(node.getLeft()));
		sb.append(node.getData() + " ");
		sb.append(inOrderTraversalHelper(node.getRight()));
		return sb.toString();
	}
	
	//Percurso Pre Ordem
	public String preOrderTraversal() {
		return preOrderTraversalHelper(root);
	}
	private String preOrderTraversalHelper(BTNode node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(node.getData() + " ");
		sb.append(preOrderTraversalHelper(node.getLeft()));
		sb.append(preOrderTraversalHelper(node.getRight()));
		return sb.toString();
	}
	
	//Percurso Pos Ordem
	public String postOrderTraversal() {
		return postOrderTraversalHelper(root);
	}
	private String postOrderTraversalHelper(BTNode node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(postOrderTraversalHelper(node.getLeft()));
		sb.append(postOrderTraversalHelper(node.getRight()));
		sb.append(node.getData() + " ");
		return sb.toString();
	}
	
	public Float calculo() {
		return getRoot().visitar();
	}
	
	
	//Metodo buildExpressionTree
	public void buildExpressionTree(List <String> expPosfixa) {
		//Criar a arvore a partir da expressao pos-fixa
		Stack<BTNode> nodeStack = new Stack<>();
		for (int i =0; i<expPosfixa.size();i++) {
			if (isOperator(expPosfixa.get(i))) {
				//Operador encontrado, criar no operador
				BTNodeOperador operatorNode = new BTNodeOperador(expPosfixa.get(i).charAt(0));
				//Pop dois operandos da pilha
				BTNode operando2= nodeStack.pop();
				BTNode operando1= nodeStack.pop();
				//Definir os filhos do no operador
				operatorNode.setLeft(operando1);
				operatorNode.setRight(operando2);
				//Empilhar o no operador
				nodeStack.push(operatorNode);
			}
			else {
				//Operando encontrado, criar no operando
				float valor = Float.parseFloat(expPosfixa.get(i));
				BTNodeOperando operandNode = new BTNodeOperando(valor);
				//Empilhar o no operando
				nodeStack.push(operandNode);

				}
			}
			// O ultimo no na pilha eh a raiz da arvore
			root = nodeStack.pop();
	
	} //fim da classe buildExpressionTree
	
	
	
	
	//Metodo toString()
	@Override
	public String toString() {
		return "BinaryTree - isEmpty(): " + isEmpty() + ", getDegree(): " + root.getDegree() + ", getHeight(): " + root.getHeight() + ", root => { " + root + " }";
	}
	
} // fim da classe BinaryTree
