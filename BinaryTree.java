/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU				TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 				TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA			TIA: 32210744
*/

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	private Node root;
	public BinaryTree() {
		this(null);
	}
	public BinaryTree(Node root) {
		this.root = root;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public int getDegree() {
		return getDegreeHelper(root);
	}
	
	private int getDegreeHelper(Node node) {
		if (node == null || node.isLeaf()) {
			return 0;
		}
		int degree = node.getDegree();
		if (node.hasLeftChild())
			degree = Math.max(degree, getDegreeHelper(node.getLeft()));
		if (node.hasRightChild())
			degree = Math.max(degree,getDegreeHelper(node.getRight()));
		return degree;
	}
	
	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}
		return root.getHeight();	
	}
	
	//Percurso Em ordem
	public String inOrderTraversal() {
		return inOrderTraversalHelper(root);
	}
	private String inOrderTraversalHelper(Node node) {
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
	private String preOrderTraversalHelper(Node node) {
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
	private String postOrderTraversalHelper(Node node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(postOrderTraversalHelper(node.getLeft()));
		sb.append(postOrderTraversalHelper(node.getRight()));
		sb.append(node.getData() + " ");
		return sb.toString();
	}
	
	//Percurso em Profundidade
	public String levelOrderTraversal() {
		return levelOrderTraversalHelper(root);
	}
	private String levelOrderTraversalHelper(Node node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node visited = queue.remove();
			sb.append(visited.getData() + " ");
			if(visited.hasLeftChild()) {
				queue.add(visited.getLeft());
			}
			if (visited.hasRightChild()) {
				queue.add(visited.getRight());
			}
		}
		return sb.toString();
	}
	
	//Metodo toString()
	@Override
	public String toString() {
		return "BinaryTree - isEmpty(): " + isEmpty() + ", getDegree(): " + getDegree() + ", getHeight(): " + getHeight() + ", root => { " + root + " }";
	}
	
} // fim da classe BinaryTree
