package edu.oswego.cs.csc385;

/**
 * This class is a framework for the implementation of the 
 * Josephus-Problem (aka Josephus' Circle, Josephus Algorithm, or Enny Meeny Miney Moe).
 * <p>
 * Idea and original description from: <a href="http://thedailywtf.com/Comments/Programming-Praxis-Josephus-Circle.aspx" target="_blank">TheDailyWTF.com</a>
 * </p><p>
 * Titus Flavius Josephus was an important historian in the first century. 
 * He survived the occupation and destruction of Jerusalem in 70 AD
 * and began writing many accounts on the history of Judaism. His work remains an important source of knowledge about the Jewish faith until now.
 * and show a non-biblical view on early Christianity. But also his other work contribute significantly 
 * to historical sciences. For example, he tells the story about how he escaped certain death
 * -- just by being at the right time in the right place: play the game of eeny meeny miney moe.
 * </p><p>
 * Legend has it that Josephus and 40 soldiers fled from occupation through the toman empire and hid in caves in the mountains. Surrounded by
 * Roman legions, they saw now way out except -- of course -- to kill themselves. Just like Klingons,
 * they thought it better to be dead than to be imprisoned.
 * </p><p>
 * In order to decide who shall kill themselves when, the soldiers stood in a circle
 * and started counting clockwise at a random position. They counted to 3
 * and the dude at position 3 took the ax and did what needed to be done. 
 * The soldiers reset to zero and kept counting, with every third soldiers doing his duty...
 * until only one more soldiers remained.<br>
 * Josephus wasn't so keen on offing himself, so he thought of the perfect way of staying alive! He quickly figured out
 * what the last position to be counted to was - and simply stood there. That way, he ensured that he would be
 * the last man standing.
 * </p>
 * @author  B. Tenbergen [bastian.tenbergen@oswego.edu]
 * @version 2022-11-14
 * @since   2010-05-26
 * @see     JosephusCircle
 */
public abstract class JosephusCircle implements Runnable {
	
	int lastManStanding;
	
	/**
	 * Number of iterations of execution in concurrent scenarios.
	 */
	final int iterations;
	
	/**
	 * Number of soldiers in the circle.
	 */
	final int soldiers;
	
	/**
	 * Magic number to which they are counting. The person at position count
         * shall kill themselves. 
	 */
	final int count;
	
	/**
	 * Creates a new instance of the Josephus Circle
	 * @param p Number of soldiers in the circle. May not be zero.
	 * @param c Magic number until which they count. May not be zero.
	 * @param i Number of executions in concurrent scenarios. Does the same thing over and over just to make sure the algorithms execute sufficiently long. Will be ignored in sequential scenarios. May not be zero.
	 */
	public JosephusCircle(int p, int c, int i) {
		this.soldiers     = Math.abs(p);
		this.count       = Math.abs(c);
		this.iterations = Math.abs(i);
	}
	
	/**
	 * Executes the algorithm sequentially.
	 * @return The "safe spot".
	 */
	public abstract int algorithm();
	
	/**
	 * Executes the algorithm concurrently.
	 */
	@Override
	public void run() {
//		this.algorithm();
		for (int i = 0; i < this.iterations; i++) {
                    try { Thread.sleep(10); } catch (Exception e) {} // just to slow things down for profiling...
                    this.lastManStanding = this.algorithm();
                }
	}
}
