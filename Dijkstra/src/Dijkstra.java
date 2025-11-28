import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Dijkstra {
	private Graph G;
	public Dijkstra(Graph newGraph) {
		this.G = newGraph;
	}
	
	public Node[] shortestPath(Node source, Node destination) {
		// for all Nodes in the graph, set the temporary current minimum value
		// to infinity, and for each of the nodes if the node is not marked and currentNode
		// d value is less than current minimum value, update min to current d value and 
		// update umin value to u.
		// once the node is marked for each edge of umin node if the second node is not marked 
		// compare between the umin.d + weight of edge to secondNode.d and if v.d is greater 
		// v.d = umin.d + weight(umin, v) and v.p = umin
		
		source.setD(0);
		for (int i = 0; i < this.G.nodes.length; i++) {
			int min = 2147483647;
			Node uMin = null;
			System.out.println(this.G.nodes[i]);

			for (int j = 0; j < this.G.nodes.length; j++) {
				if (this.G.nodes[j].getMark() == false) {
					if (this.G.nodes[j].getD() < min) {
						System.out.println("I found a Node with value less than min: " + this.G.nodes[j]);
						min = this.G.nodes[j].getD();
						uMin = this.G.nodes[j];
						
					}
				}
			}
			System.out.println("Round " + (i+1) + " uMin is: node " + uMin.getName() + " with d = " + min);
			uMin.setMark(true);
			
			System.out.println(Arrays.toString(this.G.nodes));
			
			ArrayList<Edge> arr = this.G.incidentEdges(uMin);
			for (int l = 0; l < arr.size(); l++) {
				Edge currentEdge = arr.get(l);
				System.out.println(currentEdge);
				Node secondNode = currentEdge.getSecondNode();
				if (secondNode.getMark() == false) {
					if (uMin.getD() + currentEdge.getWeight() < secondNode.getD()) {
						System.out.println("here: " + currentEdge.getWeight());
						int secondD = uMin.getD() + currentEdge.getWeight();
						
						secondNode.setD(secondD);
						secondNode.setP(uMin);
					}
				}
			}			
		}
		// you want to report the shortest path from source node to destination
		// so, let's say you will report like this:
		// shortest path from node 0 to node 7 is 0->1->2->5->7 for 4 unites
		// if we are at a current Node and the node is marked, then you will return the p of the current node and
		// record it at a list
		System.out.println("final dijkstra results: " + Arrays.toString(this.G.nodes));
		for (int i = 0; i < this.G.nodes.length; i++) {
			if (this.G.nodes[i].getMark() == true) {
				
				if (this.G.nodes[i] == source) {
					//Node[] path = new Node[]
				}
			}
		}
		System.out.println("The p I am looking for is: " + destination.getP().toString());
		//
		Node current = destination;
		Stack<Node> s1 = new Stack();
		while(current != null) {
			s1.push(current);
			current = current.getP();
			
			System.out.println("Stack: " + s1);
			

		}
		int counter = 0;
		int [] path = new int[s1.size()];
		for (int i = 0; i < path.length; i++) {
			Node n = s1.pop();
			int name = n.getName();
			path[i] = name;
			counter = destination.getD();
		}
		String res = "";
		for (int i = 0; i < path.length; i++) {
			
			if (i < path.length - 1) {
				res += path[i] + "->";
			} else {
				res += path[i];
			}	
		}
		
		System.out.println("path: " + Arrays.toString(path));
		System.out.println("res: " + res + " D: " + counter + "units");

		return null;
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(8);
//		g1.insertEdge(g1.getNode(0), g1.getNode(1), 1);
//		g1.insertEdge(g1.getNode(0), g1.getNode(2), 4);
//		g1.insertEdge(g1.getNode(0), g1.getNode(3), 2);
//		g1.insertEdge(g1.getNode(1), g1.getNode(2), 1);
//		g1.insertEdge(g1.getNode(1), g1.getNode(4), 3);
//		g1.insertEdge(g1.getNode(2), g1.getNode(4), 1);
//		g1.insertEdge(g1.getNode(2), g1.getNode(5), 3);
//		g1.insertEdge(g1.getNode(2), g1.getNode(3), 2);
//		g1.insertEdge(g1.getNode(3), g1.getNode(6), 1);
//		g1.insertEdge(g1.getNode(4), g1.getNode(7), 1);
//		g1.insertEdge(g1.getNode(5), g1.getNode(7), 1);
//		g1.insertEdge(g1.getNode(5), g1.getNode(6), 2);
//		g1.insertEdge(g1.getNode(6), g1.getNode(7), 4);
		System.out.println(g1);
//		Dijkstra d1 = new Dijkstra(g1);
//		d1.shortestPath(g1.getNode(0), g1.getNode(7));
	}

}
