import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class StudentAtendanceManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> attendance = new HashMap<>();
        boolean running = true;
        while(running){
            System.out.println("\n ---Student Attendence Manager---:");
            System.out.println("1.Add Student");
            System.out.println("2.Mark present");
            System.out.println("3.Check Attendance");
            System.out.println("4.Get Percentage");
            System.out.println("Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                System.out.print("Enter the name of the student:");
                String input = sc.nextLine();
                String names[]= input.split(",");
                for(String name:names){
                    name:name.trim();
                    if (!attendance.containsKey(name)) {
                attendance.put(name,0);
                System.out.println("Name added succesfully "+name);
                    }else{
                        System.out.println(name+ "is already in the system");
                    }
                }
                break;

                case 2:
                System.out.println("Enter the student name to mark Attendence: ");
                String StudentName = sc.nextLine();
                String namess[] = StudentName.split(",");
                for(String nam:namess){
                if(attendance.containsKey(nam)){;
                int currentdays = attendance.get(nam);
                attendance.put(nam,currentdays+1);
                System.out.println("Marked attendance for: "+nam);
            }
            else{
                System.out.println("Student name not in records");
            }
        }
                break;

                case 3:
                if(attendance.isEmpty()){
                    System.out.println("No records found");
                }else{
                    System.out.println("\n ---Attendance records---");
                    for(String student:attendance.keySet()){
                        int days = attendance.get(student);
                        System.out.println(student+"- "+ days +" days present"); 
                    }
                }
                break;

                case 4:
                System.out.print("enter the student name:");
                String sName = sc.nextLine();
                if(attendance.containsKey(sName)){
                    System.out.print("Enter the num of working days: ");
                    int totaldays = sc.nextInt();
                    sc.nextLine();

                    int presentdays = attendance.get(sName);
                    double percentaage = ((double)presentdays/totaldays)*100;
                    System.out.printf("%s was present for %.2f%% of the clases \n",sName,percentaage);
                }else{
                    System.out.println("Record not found");
                }
                break;

                case 5:
                try{
                    FileWriter writer = new FileWriter("attendance.txt");
                    for(String student:attendance.keySet()){
                        int days = attendance.get(student);
                        writer.write(student+" attended for "+days+" days");
                    }
                    writer.close();
                    System.out.println("Attendance saved ");
                }catch(IOException e){
                    System.out.println("An error occured while saving attendance");
                    e.printStackTrace();
                }
                running=false;
                System.out.println("Exiting Attendancce Manager");
                break;

                }
                

                }

                // default:
                // System.out.println("Invalid option");

            }
           
        }
//         sc.close();
//     }
    
// }
