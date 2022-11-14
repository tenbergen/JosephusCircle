package edu.oswego.cs.csc385;

/**
 * An implementation of the Josephus-Problem using a LinkedList.
 * @author  B. Tenbergen [bastian.tenbergen@oswego.edu]
 * @version 2022-11-14
 * @since   2010-05-26
 * @see     JosephusCircle
 */
public class Algorithm1 extends JosephusCircle {
	
	/**
	 * @see JosephusCircle 
	 */
	public Algorithm1(int p, int c, int i) {
		super(p, c, i);
	}

	/**
	 * @see JosephusCircle
	 */
	@Override
	public int algorithm() {
		java.util.LinkedList<Integer> alive = new java.util.LinkedList<Integer>();
		
		for (int i = 1; i <= this.soldiers; i++) alive.add(i);

		int index = 0;
		while (alive.size() > 1)
		alive.remove(index = (index + count - 1) % alive.size());

		this.lastManStanding = alive.get(0);
		return this.lastManStanding; 
	}
}
