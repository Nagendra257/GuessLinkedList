package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
	// TODO
	private LLIntegerNode link;
	private int num;
	public LLIntegerNode(int number) {
		num=number;
		link=null;
	}
	public int getInfo() {
		return num;
	}
	public LLIntegerNode getLink() {
		return link;
	}
	public void setInfo(int no) {
		num=no;
	}
	public void setLink(LLIntegerNode k) {
		link=k;
	}
}

