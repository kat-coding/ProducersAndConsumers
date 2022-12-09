package IndividualThree;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Katherine Watkins
 * SDEV 301
 * IND #3
 * Application class that constructs each application when called by Applicants class
 */

public class Application {
    private static AtomicInteger nextId = new AtomicInteger(10000);
    private int applicationId;
    private int creditScore;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;

    /**
     * applicationID is AtomicInteger that will increment as the applications are created
     * @param creditScore randomly generated credit score
     * @param requestedLimit randomly generated requestedLimit for application
     */
    public Application(int creditScore, int requestedLimit){
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
        this.applicationId = getNextId();
    }

    /**
     *
     * @return increments and returns nextID for applicationIDs
     */
    public int getNextId() {
        return nextId.getAndIncrement();
    }

    /**
     *
     * @return get applicationID for application
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     *
     * @return get credit score for application
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * @return get limit requested on application
     */
    public int getRequestedLimit() {
        return requestedLimit;
    }

    /**
     * @return returns if the application was approved, this is changed by the CreditCompany class
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @return returns the limit approved by the CreditCompany class
     */
    public int getApprovedLimit() {
        return approvedLimit;
    }

    /**
     * @param creditScore is randomly generated in applicants and passed in during construction
     */
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * @param requestedLimit is randomly generated in applicants
     */
    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    /**
     *
     * @param approved is set by the CreditCompany during processing
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * @param approvedLimit sets the approved credit limit
     */
    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
