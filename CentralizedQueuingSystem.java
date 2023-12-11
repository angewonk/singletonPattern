import java.util.Random;

public class CentralizedQueuingSystem {
    private static CentralizedQueuingSystem instance;
    private int helpDeskACurrentQueueNumber;
    private int helpDeskBCurrentQueueNumber;
    private int helpDeskCCurrentQueueNumber;

    private CentralizedQueuingSystem() {
        helpDeskACurrentQueueNumber = 1;
        helpDeskBCurrentQueueNumber = 1;
        helpDeskCCurrentQueueNumber = 1;
    }

    public static synchronized CentralizedQueuingSystem getInstance() {
        if (instance == null)
            instance = new CentralizedQueuingSystem();
        return instance;
    }

    public synchronized void getCurrentQueueNumber() {
        System.out.println("Current Queue Numbers:");
        System.out.println("Help Desk A: " + helpDeskACurrentQueueNumber);
        System.out.println("Help Desk B: " + helpDeskBCurrentQueueNumber);
        System.out.println("Help Desk C: " + helpDeskCCurrentQueueNumber);
    }

    public synchronized void setCurrentQueueNumber() {
        Random random = new Random();
        // Prints queue
        int min = 1;
        int max = 3;
        int deskStation = random.nextInt(max - min + 1) + min;

        switch (deskStation) {
            case 1:
                System.out.println("Person entered Help Desk A with queue number: HD(A)-" + helpDeskACurrentQueueNumber);
                helpDeskACurrentQueueNumber++;
                break;
            case 2:
                System.out.println("Person entered Help Desk B with queue number: HD(B)-" + helpDeskBCurrentQueueNumber);
                helpDeskBCurrentQueueNumber++;
                break;
            case 3:
                System.out.println("Person entered Help Desk C with queue number: HD(C)-" + helpDeskCCurrentQueueNumber);
                helpDeskCCurrentQueueNumber++;
                break;
        }
    }

    public synchronized void resetQueue(int deskStation, int currentNumber) {
        switch (deskStation) {
            case 1:
                helpDeskACurrentQueueNumber = currentNumber;
                break;
            case 2:
                helpDeskBCurrentQueueNumber = currentNumber;
                break;
            case 3:
                helpDeskCCurrentQueueNumber = currentNumber;
                break;
        }
    }
}
