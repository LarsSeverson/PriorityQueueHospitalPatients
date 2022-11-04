import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
    private static int fileSize = -1;
    private static PriorityQueue<Object> hospitalQueue;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t{Hospital Record Priority Queue}\n");
        while(true){
            System.out.println("1. insert" +
                    "\n2. peek" +
                    "\n3. nextPatient" +
                    "\n4. removePatient" +
                    "\n5. size" +
                    "\n6. updatePriority" +
                    "\n7. exit");
            System.out.print("\nEnter a number: ");
            switch (input.nextLine()) {
                case "1" -> {
                    hospitalQueue = new PriorityQueue<>(getSize(new BufferedReader(new FileReader("src/inputFile2.txt"))));
                    insertRecords(new BufferedReader(new FileReader("src/inputFile2.txt")));
                    System.out.println("Input file is read successfully.");
                }
                case "2" -> {
                    System.out.println("The patient detail with the highest priority is as follows:");
                    System.out.println(hospitalQueue.peek());
                }
                case "3" -> {
                    System.out.println("The patient removed from the heap is as follows:");
                    System.out.println(hospitalQueue.nextPatient());
                }
                case "4" -> {
                    System.out.println("Please enter the patient information to remove from the queue:");
                    hospitalQueue.removePatient(hospitalQueue.find(getPatientInfo()));
                }
                case "5" -> System.out.println("Number of record in the database: " + hospitalQueue.size());
                case "6" -> {
                    System.out.println("Please enter the patient information to change UNOS status:");
                    hospitalQueue.updatePriority(getPatientInfo());
                }
                case "7" -> System.exit(1);
                default -> System.out.println("Not a valid option.");
            }

        }

    }
    private static void insertRecords(BufferedReader fileName){
        String line;
        int i = 0;
        try{
            while((line = fileName.readLine()) !=  null){
                if (i > 0){
                    String[] info = line.split(";");
                    hospitalQueue.insert(
                            new Patients(info[0], info[1], info[2], info[3],
                                         info[4], info[5], info[6], info[7],
                                         info[8], info[9], info[10], info[11],
                                         info[12]));
                }
                // skip first line
                i++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static int getSize(BufferedReader fileName){
        try{
            while(fileName.readLine() != null){
                fileSize++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return fileSize;
    }
    private static Patients getPatientInfo(){
        Scanner input = new Scanner(System.in);

        System.out.print("\nPlease enter patient’s first name: ");
        String name = input.nextLine();
        System.out.print("Please enter patient’s last name: ");
        String last = input.nextLine();
        System.out.print("Please enter patient’s data of birth: ");
        String dob = input.nextLine();
        System.out.print("Please enter patient’s address: ");
        String address = input.nextLine();
        System.out.print("Please enter patient’s city: ");
        String city = input.nextLine();
        System.out.print("Please enter patient’s county: ");
        String county = input.nextLine();
        System.out.print("Please enter patient’s state: ");
        String state = input.nextLine();
        System.out.print("Please enter patient’s zip code: ");
        String zip = input.nextLine();
        System.out.print("Please enter patient’s phone number (1st Preference): ");
        String phone1 = input.nextLine();
        System.out.print("Please enter patient’s phone number (2nd Preference): ");
        String phone2 = input.nextLine();
        System.out.print("Please enter patient’s email address: ");
        String email = input.nextLine();
        System.out.print("Please update the UNOS Status: ");
        String unos = input.nextLine();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        return new Patients(name, last, address, city, county, state, zip, phone1, phone2, email, dateFormat.format(date), unos, dob);
    }
}
