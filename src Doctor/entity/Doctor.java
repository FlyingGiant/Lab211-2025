package entity;

import utils.Validate;

public class Doctor {
    String code;
    String name;
    String specialization;
    int availability;

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public static Doctor inputDoctor() {
        String code = Validate.getString("Enter Code: ", "Invalid code", ".*\\S.*");
        String name = Validate.getString("Enter Name: ", "Invalid name", ".*\\S.*");
        String specialization = Validate.getString("Enter Specialization: ", "Invalid specialization", ".*\\S.*");
        int availability = Validate.getInt("Enter Availability: ", "Out of range", "Invalid availability", 0,
                Integer.MAX_VALUE);
        return new Doctor(code, name, specialization, availability);
    }

    public static void updateDoctor(Doctor doctor) {
        String newName = Validate.getString("Enter Name: ", "Invlaid name", ".*\\S.*");
        if (!newName.isEmpty()) {
            doctor.setName(newName);
        }
        String newSpecialization = Validate.getString("Enter Specialization: ", "Invalid specialization", ".*\\S.*");
        if (!newSpecialization.isEmpty()) {
            doctor.setSpecialization(newSpecialization);
        }
        String newAvailability = Validate.getString("Enter Availability: ", "Invalid availability", ".*\\S.*");
        if (!newAvailability.isEmpty()) {
            int avail = Integer.parseInt(newAvailability);
            doctor.setAvailability(avail);
        }
    }

    public void display() {
        System.out.printf("Code: %-10s | Name: %-20s | Avail: %-3d | Special: %s\n", code, name, availability,
                specialization);
    }

}
