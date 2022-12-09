package IndividualThree;
import java.util.concurrent.*;

/**
 * @author Katherine Watkins
 * SDEV 301
 * IND #3
 * Application Queue class creates shared resource ApplicationQueue
 */

public class ApplicationQueue {
    //shared queue
    private static BlockingQueue<Application> apps;

    //shared queue constructor
    public ApplicationQueue() {
        this.apps = new ArrayBlockingQueue<Application>(5);
    }

    /**
     *
     * @param app Application object to be added to queue
     * @throws InterruptedException
     */
    public void addApplication(Application app) throws InterruptedException {
        //.put adds the app to the queue
                apps.put(app);
    }

    /**
     *
     * @return returns Application removed from queue for processing
     * @throws InterruptedException
     */
    public Application removeApplication() throws InterruptedException {
        //.take() removes the application from the queue then returns it to the Credit Company logic
            Application application = apps.take();
            return application;
    }
}
