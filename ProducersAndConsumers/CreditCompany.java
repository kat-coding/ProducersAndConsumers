package IndividualThree;
//TAKE

/**
 * @author Katherine Watkins
 * SDEV 301
 * IND #3
 * Credit Company Class that processes applications from the shared queue
 */

public class CreditCompany implements Runnable {

    private ApplicationQueue mySharedQueue;

    /**
     *
     * @param mySharedQueue is the shared queue object between the credit company and applicants
     */
    public CreditCompany(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * overridden run will get the application then determine approval,
     * also updates the approval on the object using the .setApproved method
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": started!");


        while (!Thread.interrupted()) {
            try {
                Application current = mySharedQueue.removeApplication();


                String approval = "";
                String requested = "";
                int score = current.getCreditScore();


                if (score < 580) {
                    approval = " is not approved.";
                    current.setApproved(false);
                }
                if (score >= 580 && score <= 669) {
                    approval = " is approved for $5,000.";
                    current.setApproved(true);
                    current.setApprovedLimit(5000);
                    requested = " (requested: " + current.getRequestedLimit()+ ")";
                }
                if (score >= 670 && score <= 739) {
                    approval = " is approved for $10,000.";
                    current.setApproved(true);
                    current.setApprovedLimit(10000);
                    requested = " (requested: " + current.getRequestedLimit()+ ")";
                }
                if (score >= 740 && score <= 799) {
                    approval = " is approved for $25,000.";
                    current.setApproved(true);
                    current.setApprovedLimit(25000);
                    requested = " (requested: " + current.getRequestedLimit()+ ")";
                }
                if (score >= 800) {
                    approval = " is approved for $50,000.";
                    current.setApproved(true);
                    current.setApprovedLimit(50000);
                    requested = " (requested: " + current.getRequestedLimit()+ ")";
                }

                System.out.println(Thread.currentThread().getName() + ": " + current.getApplicationId() + " with credit score " + current.getCreditScore() + approval + requested);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                break;
            }
        }
    }
}

