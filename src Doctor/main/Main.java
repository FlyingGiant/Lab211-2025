package main;

import java.util.List;

//import bo.DoctorBO;
import bo.DoctorBO2;
import entity.Doctor;
import utils.Validate;

public class Main {
    public static void main(String[] args) {
        DoctorBO2.addDoctor(new Doctor("Doc 1", "Nghia", "Orthopedics", 3));
        DoctorBO2.addDoctor(new Doctor("Doc 2", "Phuong", "Obstetrics", 2));
        DoctorBO2.addDoctor(new Doctor("DOC 3", "Lien", "orthodontic", 1));
        while (true) {
            System.out.println("======= Doctor Management =======");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            int choice = Validate.getInt("Enter your choice: ",
                    "Invalid choice",
                    "Invalid choice",
                    0, 5);
            switch (choice) {
                case 1:
                    System.out.println("------- Add Doctor -------");
                    Doctor doc = Doctor.inputDoctor();
                    if (DoctorBO2.addDoctor(doc)) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Add fail");
                    }
                    break;
                case 2:
                    System.out.println("------- Update Doctor -------");
                    String code = Validate.getString("Enter Code: ", "Invlaid code", ".*\\S.*");
                    if (DoctorBO2.updateDoctor(code)) {
                        System.out.println("Updated");
                    } else {
                        System.out.println("Code does not exist");
                    }
                    break;
                case 3:
                    System.out.println("------- Delete Doctor -------");
                    code = Validate.getString("Enter Code: ", "Invlaid code", ".*\\S.*");
                    if (DoctorBO2.deleteDoctor(code)) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("Code does not exist");
                    }
                    break;
                case 4:
                    System.out.println("------- Search Doctor -------");
                    String text = Validate.getString("Enter text: ", "Invalid code", ".*\\S.*");// Dang loi
                    text = text.toLowerCase();
                    List<Doctor> found = DoctorBO2.searchDoctor(text);
                    System.out.println("------- Result -------");
                    System.out.printf("%-10s %-15s %-20s %-5s\n", "Code", "Name", "Specialization", "Availability");
                    if (found.isEmpty()) {
                        System.out.println("No doctors found.");
                    } else {
                        for (Doctor d : found) {
                            System.out.printf("%-10s %-15s %-20s %-15d\n",
                                    d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
                        }
                    }
                    break;
                case 5:
                    return;

            }
        }
    }

}
