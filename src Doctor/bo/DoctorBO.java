package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Doctor;
import utils.Validate;

public class DoctorBO {
    static ArrayList<Doctor> doctors = new ArrayList<>();

    public static void addDoctor() {
        String code;
        while (true) {
            code = Validate.getString("Enter Code: ", "Invalid Code", ".*\\S.*");
            if (findDoctorByCode(code) == null) {
                break;
            }
            System.out.println("Code is duplicated");
        }
        String name = Validate.getString("Enter Name: ",
                "Invalid Name", ".*\\S.*");
        String specialization = Validate.getString("Enter Specialization: ",
                "Invalid Specialization", ".*\\S.*");
        int availability = Validate.getInt("Enter Availability: ",
                "Out of range",
                "Invalid availability",
                0, Integer.MAX_VALUE);
        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctors.add(newDoctor);
        System.out.println("Added new doctor!");
    }

    public static void updateDoctor() {

        String code = Validate.getString("Enter Code: ", "Doctor code not exist", ".*\\S.*");
        Doctor doctorToUpdate = findDoctorByCode(code);
        if (doctorToUpdate == null) {
            System.out.println("Doctor code does not exist.");
            return;
        }
        String newName = Validate.getString("Enter Name: ", "Invalid name", "^$|.*\\S.*");
        if (!newName.trim().isEmpty()) {
            doctorToUpdate.setName(newName);
        }
        String newSpecialization = Validate.getString("Enter Specialization: ", "Invalid Specialization", "^$|.*\\S.*");
        if (!newSpecialization.trim().isEmpty()) {
            doctorToUpdate.setSpecialization(newSpecialization);
        }

        String newAvailability = Validate.getString("Enter Availability: ", "Invalid availability", "^$|\\d+");
        if (!newAvailability.isEmpty()) {
            doctorToUpdate.setAvailability(Integer.parseInt(newAvailability));
        }
        System.out.println("Updated doctor!");
    }

    public static void deleteDoctor() {
        String code = Validate.getString("Enter Code: ", "Invalid Code", ".*\\S.*");
        if (findDoctorByCode(code) == null) {
            System.out.println("Doctor code does not exist");
        } else {
            doctors.remove(findDoctorByCode(code));
            System.out.println("Deleted doctor");
        }
    }

    public static void searchDoctor() {
        String text = Validate.getString("Enter text: ", "Invalid text", ".*").toLowerCase();
        List<Doctor> result = new ArrayList<>();
        for (Doctor doc : doctors) {
            if (text.isEmpty() || doc.getCode().toLowerCase().contains(text)
                    || doc.getName().toLowerCase().contains(text)
                    || doc.getSpecialization().toLowerCase().contains(text)
                    || String.valueOf(doc.getAvailability()).contains(text)) {
                result.add(doc);
            }
        }
        System.out.println("------ Result ------");
        if (result.isEmpty()) {
            System.out.println("Doctor not found!");
        } else {
            System.out.printf("%-8s %-10s %-20s %-5s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : result) {
                System.out.printf("%-8s %-10s %-20s %-5d\n",
                        doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    public static Doctor findDoctorByCode(String code) {
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(code)) {
                return d;
            }
        }
        return null;
    }

}
