
public class Node {
	private String data;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node() {
		this("", null);
	}
	public Node(String data) {
		this(data, null);
	}
	public Node(String data, Node parent) {
		this.data = data;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
		left.setParent(this);
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
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
	
	@Override
	public String toString() {
		return "data: " + data
				+ ", parent: " + (parent != null ? parent.getData() : "null")
				+ ", left: " + (left != null ? left.getData() : "null")
				+ ", right: " + (right != null ? right.getData(): "null")
				+ ", isRoot()" + isRoot()
				+ ", isLeaf(): " + isLeaf()
				+ ", getDegree(): " + getDegree()
				+ ", getLevel(): " + getLevel()
				+ ", getHeight(): " + getHeight();
	}
	
} // Fim da classe Node.java
