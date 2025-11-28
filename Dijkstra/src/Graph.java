import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	protected Node[] nodes;
	private ArrayList<Edge>[] edgearr;
	
	public Graph(int num) {
		this.nodes = new Node[num];
		this.edgearr = new ArrayList[nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			Node n = new Node(i);
			this.nodes[i] = n;
			ArrayList<Edge> arrlst = new ArrayList<Edge>();
			this.edgearr[i] = arrlst;
			
		}
	}
	
	public void insertEdge(Node u, Node v, int weight) {
		Edge e1 = new Edge(u, v);
		e1.setWeight(weight);
		this.edgearr[u.getName()].add(e1);
		Edge e2 = new Edge(v, u);
		e2.setWeight(weight);
		this.edgearr[v.getName()].add(e2);
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < nodes.length; i++) {
			res += i + ": " + edgearr[i] + "\n";
		}
		return res;
	}
	
	public Node getNode(int name) {
		return this.nodes[name];
	}
	
	public Edge getEdge(Node u, Node v) {
		Edge e = null;
		for (int i = 0; i < this.edgearr[u.getName()].size(); i++) {
			if (v == this.edgearr[u.getName()].get(i).getSecondNode()) {
				e = this.edgearr[u.getName()].get(i);
			}
		}
		return e;
	}
	public ArrayList<Edge> incidentEdges(Node u){
		return edgearr[u.getName()];
	}
	
	public boolean areAdjacent(Node u, Node v) {
		
		for (int i = 0; i < this.edgearr[u.getName()].size(); i++) {
			if (v == this.edgearr[u.getName()].get(i).getSecondNode()) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Graph g1 = new Graph(4);
		int w = 1;
		g1.insertEdge(g1.getNode(0), g1.getNode(1), 1);
		g1.insertEdge(g1.getNode(0), g1.getNode(2), 3);
		g1.insertEdge(g1.getNode(0), g1.getNode(3), 1);
		g1.insertEdge(g1.getNode(2), g1.getNode(3), 1);
		//       0  ----------- 1
		//       |	\
		//     	 |	  \
		//		 |		  \
		//       2 - ------3
		
		
		System.out.println(g1);
		System.out.println("----------------------------");
		System.out.println("All incident edges to node 2 is: " + g1.incidentEdges(g1.getNode(2)));
		System.out.println(g1.areAdjacent(g1.getNode(2), g1.getNode(3)));
		System.out.println(g1.getEdge(g1.getNode(0), g1.getNode(2)));
	}

}
