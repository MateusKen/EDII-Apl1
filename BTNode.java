/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/
package apl1;

public class BTNode {
	private BTNode parent;
	private BTNode left;
	private BTNode right;
	
	public BTNode() {
		parent = null;
		left = null;
		right = null;
	}
	
	public BTNode(BTNode parent) {
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	
	public BTNode getParent() {
		return parent;
	}
	
	public void setParent(BTNode parent) {
		this.parent = parent;
	}
	
	public BTNode getLeft() {
		return left;
	}
	
	public void setLeft(BTNode left) {
		this.left = left;
		left.setParent(this);
	}
	
	public BTNode getRight() {
		return right;
	}
	
	public void setRight(BTNode right) {
		this.right = right;
		right.setParent(this);
	}
	
	public boolean hasLeftChild() {
		return left != null;
	}
	
	public boolean hasRightChild() {
		return right != null;
	}
	
	public boolean isRoot() {
		return parent == null;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public int getDegree() {
		int degree = 0;
		if (hasLeftChild())
			++degree;
		if (hasRightChild())
			++degree;
		return degree;
	}
	
	public int getLevel() {
		if(isRoot()) {
			return 0;
		}
		return parent.getLevel() + 1;
	}
	
	public int getHeight() {
		if(isLeaf()) {
			return 0;
		}
		int height = 0;
		if (hasLeftChild())
			height = Math.max(height, left.getHeight());
		if (hasRightChild())
			height = Math.max(height, right.getHeight());
		return height + 1;
	}
	
	public float visitar() {
		return Float.NaN;
	}
	
	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
	
	public static boolean isOperand(char ch) {
		return Character.isDigit(ch) || ch == '.';	//considera ponto como parte de operandos validos (numeros decimais)
	}
	
	@Override
	public String toString() {
		return "parent: " + (parent != null ? parent.visitar() : "null")
				+ ", left: " + (left != null ? left.visitar() : "null")
				+ ", right: " + (right != null ? right.visitar(): "null")
				+ ", isRoot()" + isRoot()
				+ ", isLeaf(): " + isLeaf()
				+ ", getDegree(): " + getDegree()
				+ ", getLevel(): " + getLevel()
				+ ", getHeight(): " + getHeight();
	}
	
} // Fim da classe Node.java
