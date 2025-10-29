import java.util.*;

class Patient {
    int id;
    String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

public class patientIDPrintingDemo {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient(101, "Amit"),
            new Patient(102, "Neha"),
            new Patient(103, "Rahul"),
            new Patient(104, "Priya")
        );

        System.out.println("All Patient IDs for Verification:");

        // ✅ Using method reference instead of lambda
        patients.stream()
                .map(Patient::getId)   // Method reference to get patient ID
                .forEach(System.out::println); // Method reference to print
    }
}