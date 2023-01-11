package IndividualThree;
//PUT
//comment
/**
 * @author Katherine Watkins
 * SDEV 301
 * IND #3
 * Applicants class will add new applications to the shared queue
 */


public class Applicants implements Runnable {
    private ApplicationQueue mySharedQueue; //shared data

    /**
     *
     * @param mySharedQueue shared queue between Applicants and CreditCompany
     */

    public Applicants (ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * Random number generator
     * @param max range max for random #
     * @param min range min for random #
     * @return returns random number
     */
    public int randomNum (int max, int min){
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    /**
     * Overridden run will create applications and add to queue for one minute
     * then on random decide whether to wait between applications or not
     */
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while (!Thread.interrupted() && System.currentTimeMillis()< (start + 60000)) {

                int creditScore = randomNum(300, 850);
                int requestedLimit = randomNum(5000, 50000);
                Application cur = new Application(creditScore, requestedLimit);
                try {
                    mySharedQueue.addApplication(cur);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ": " + "created application #" + cur.getApplicationId());

                int doOrdont = randomNum(1, 2);
                if (doOrdont == 1) {
                    int delay = randomNum(100, 1200);
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        System.out.println("APPLICANTS---Thread interrupted exception: " + e);
                    }
                }




        }
        System.out.println(Thread.currentThread().getName() + " finished!");
    }
}
