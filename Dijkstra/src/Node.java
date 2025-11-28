
public class Node {
	private int name;
	private int d;
	private Node p;
	private boolean mark = false;
	
	public Node(int n) {
		this.name = n;
		this.d = 2147483647;
		this.p = null;
	}
	public Node(int n, boolean isMarked) {
		this.name = n;
		this.mark = isMarked;
		this.d = 2147483647;
		this.p = null;
	}
	
	public int getD() {
		return this.d;
	}
	
	public void setD(int newD) {
		this.d = newD;
	}
	
	public Node getP () {
		return this.p;
	}
	
	public void setP(Node newP) {
		this.p = newP;
	}
	public int getName() {
		return this.name;
	}
	
	public void setName(int n) {
		this.name = n;
	}
	
	public boolean getMark() {
		return this.mark;
	}
	
	public void setMark(boolean check) {
		this.mark = check;
	}
	
	public String toString() {
		if (this.p == null) {
			return "(" + this.name + " : " + this.mark + " : d=" + this.d + " p=null" + ")";
		} else {
			return "(" + this.name + " : " + this.mark + " : d=" + this.d + " p=" + this.p.getName() + ")";
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(0);
		System.out.println(n1);
	}

}
