import java.util.Random;

public class CentralizedQueuingSystem {
    private static CentralizedQueuingSystem instance;
    private int currQueNumA;
    private int currQueNumB;
    private int currQueNumC;

    public synchronized void setCurrentQueueNumber() {
        Random random = new Random();
        int min = 1;
        int max = 3;
        int deskStation = random.nextInt(max - min + 1) + min;

        switch (deskStation) {
            case 1:
                System.out.println("Person entered Help Desk A with queue number: HD(A)-" + currQueNumA);
                currQueNumA++;
                break;
            case 2:
                System.out.println("Person entered Help Desk B with queue number: HD(B)-" + currQueNumB);
                currQueNumB++;
                break;
            case 3:
                System.out.println("Person entered Help Desk C with queue number: HD(C)-" + currQueNumC);
                currQueNumC++;
                break;
        }
    }

    private CentralizedQueuingSystem() {
        currQueNumA = 1;
        currQueNumB= 1;
        currQueNumC= 1;
    }

    public static synchronized CentralizedQueuingSystem getInstance() {
        if (instance == null)
            instance = new CentralizedQueuingSystem();
        return instance;
    }

    public synchronized void resetQueue(int deskStation, int currentNumber) {
        switch (deskStation) {
            case 1:
                currQueNumA = currentNumber;
                break;
            case 2:
                currQueNumB = currentNumber;
                break;
            case 3:
                currQueNumC = currentNumber;
                break;
        }
    }
    public synchronized void getCurrentQueueNumber() {
        System.out.println("Current Queue Numbers:");
        System.out.println("Help Desk A: " + currQueNumA);
        System.out.println("Help Desk B: " + currQueNumB);
        System.out.println("Help Desk C: " + currQueNumC);
    }
}
