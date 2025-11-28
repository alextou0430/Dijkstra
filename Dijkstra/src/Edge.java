import java.util.ArrayList;

public class Edge {
	private int weight;
	private Node firstNode;
	private Node secondNode;
	
	public Edge(Node u, Node v) {
		this.firstNode = u;
		this.secondNode = v;
	}
	
	public Edge(Node u, Node v, int weight) {
		this.firstNode = u;
		this.secondNode = v;
		this.weight = weight;
	}
	
	public Node getFirstNode() {
		return this.firstNode;
	}
	
	public Node getSecondNode() {
		return this.secondNode;
	}
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
	
	
	public String toString() {
		return this.firstNode.getName() + " ----> " + this.secondNode.getName() + " : " + this.weight;
	}
	public static void main(String[] args) {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Edge e1 = new Edge(n1, n2);
		e1.setWeight(2);
		System.out.println(e1);
	}

}
