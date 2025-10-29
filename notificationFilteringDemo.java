import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;
    int priority; // 1 = High, 2 = Medium, 3 = Low

    public Alert(String type, String message, int priority) {
        this.type = type;
        this.message = message;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message + " (Priority: " + priority + ")";
    }
}

public class notificationFilteringDemo {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal!", 1),
            new Alert("Info", "Patient scheduled for test.", 3),
            new Alert("Warning", "Medicine dosage due soon.", 2),
            new Alert("Critical", "Low oxygen level detected!", 1),
            new Alert("Info", "Doctor appointment confirmed.", 3)
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Filter alerts by preference:");
        System.out.println("1) Only Critical\n2) Only High Priority (<=2)\n3) Only Info\n4) Show All");
        int choice = sc.nextInt();

        // ✅ Using Predicate with Lambda for dynamic filtering
        Predicate<Alert> filter;

        switch (choice) {
            case 1:
                filter = a -> a.type.equalsIgnoreCase("Critical");
                break;
            case 2:
                filter = a -> a.priority <= 2;
                break;
            case 3:
                filter = a -> a.type.equalsIgnoreCase("Info");
                break;
            case 4:
                filter = a -> true; // show all
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("\nFiltered Alerts:");
        alerts.stream()
              .filter(filter)   // apply predicate
              .forEach(System.out::println);

        sc.close();
    }
}
