import java.util.Scanner;

public class PagIbigOfficeApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        CentralizedQueuingSystem queuingSystem = CentralizedQueuingSystem.getInstance();
        CentralizedQueuingSystemMonitoring monitoringSystem = CentralizedQueuingSystemMonitoring.getInstance();
        while (true) {
            System.out.println("\n1 - Generate New Queue List");
            System.out.println("2 - Current Queue Number");
            System.out.println("3 - Reset Queue");
            System.out.println("4 - Exit");
            System.out.print("\nEnter Choice: ");
            int choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n===Queue List===");
                    for (int i = 0; i < 15; i++) {
                        queuingSystem.setCurrentQueueNumber();
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    monitoringSystem.displayCurrentQueueNumber();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Choose Desk to Reset");
                    System.out.print("Desk Station A = 1, B = 2, C = 3: ");
                    int deskStation = userInput.nextInt();
                    System.out.print("Reset Number: ");
                    int resetNum = userInput.nextInt();
                    queuingSystem.resetQueue(deskStation, resetNum);
                    System.out.println();
                    monitoringSystem.displayCurrentQueueNumber();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Application Closed");
                    userInput.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}