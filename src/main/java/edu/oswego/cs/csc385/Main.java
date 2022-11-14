package edu.oswego.cs.csc385;

/**
 * Executes the three implementations concurrently.
 *
 * @author B. Tenbergen [bastian.tenbergen@oswego.edu]
 * @version 2022-11-14
 * @since 2010-05-26
 */
public class Main {

    /**
     * Starts all three algorithms in an own thread.
     *
     * @param args n/A
     */
    public static void main(String[] args) {

        //try { Thread.sleep(30000); } catch (Exception e) { } // just to slow things down for profiling...

        java.util.Random r = new java.util.Random();
        int p = r.nextInt(100) + 1;
        int c = r.nextInt(100) + 1;
        int i = r.nextInt(1000000) + 1;

        System.out.println("Starting Algorithm Threads with: ");
        System.out.println("  p = " + p);
        System.out.println("  c = " + c);
        System.out.println("  i = " + i);

        JosephusCircle jc1 = new Algorithm1(p, c, i);
        JosephusCircle jc2 = new Algorithm2(p, c, i);
        JosephusCircle jc3 = new Algorithm3(p, c, i);

        Thread a1 = new Thread(jc1);
        Thread a2 = new Thread(jc2);
        Thread a3 = new Thread(jc3);

        //Sets the name of the threads... just for convenience in TPTP
        a1.setName("Algorithm1");
        a2.setName("Algorithm2");
        a3.setName("Algoritum3");

        a1.start();
        a2.start();
        a3.start();

        System.out.println(a1.getName() + " said the Last Man Standing is: " + jc1.lastManStanding);
        System.out.println(a2.getName() + " said the Last Man Standing is: " + jc2.lastManStanding);
        System.out.println(a3.getName() + " said the Last Man Standing is: " + jc3.lastManStanding);

        System.out.println("Done.");
    }
}
