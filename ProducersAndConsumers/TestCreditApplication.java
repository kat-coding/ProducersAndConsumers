package IndividualThree;

/**
 * @author Katherine Watkins
 * SDEV 301
 * IND #3
 * Driver class that starts threads for producers and consumers
 */

public class TestCreditApplication {
    /**
     * final int for number of consumer and producer threads
     */
    public static final int NUM_CONSUMERS = 2;
    public static final int NUM_PRODUCERS = 3;

    public static void main(String[] args) throws InterruptedException{
        ApplicationQueue apps = new ApplicationQueue();

        Thread[] consumers = new Thread[NUM_CONSUMERS];

        Thread[] producers = new Thread[NUM_PRODUCERS];

        for(int i = 0; i < NUM_CONSUMERS; i++) {
            CreditCompany company = new CreditCompany(apps);
            consumers[i] = new Thread(company, "C" + i);
            consumers[i].start();
        }
        for(int j = 0; j < NUM_PRODUCERS; j++) {
            producers[j] = new Thread( new Applicants(apps), "P" + j);
            System.out.println(producers[j].getName() + " started!");
            producers[j].start();
        }
        for(int j = 0; j < NUM_PRODUCERS; j++) {
            producers[j].join();
        }
    //sleep to let program finish
        Thread.sleep(1000);
    //interrupt consumers to end program
        for(int i = 0; i < NUM_CONSUMERS; i++) {
            consumers[i].interrupt();
        }
    }
}
