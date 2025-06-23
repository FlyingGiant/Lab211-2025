package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Doctor;

public class DoctorBO2 {
    private static final ArrayList<Doctor> doctors = new ArrayList<>();

    public static boolean addDoctor(Doctor doctor) {
        if (isCodeExists(doctor.getCode())) {
            return false;
        }
        doctors.add(doctor);
        return true;
    }

    public static boolean updateDoctor(String code) {
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(code)) {
                Doctor.updateDoctor(d);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteDoctor(String code) {
        return doctors.removeIf(d -> d.getCode().equalsIgnoreCase(code));
    }

    public static List<Doctor> searchDoctor(String text) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doc : doctors) {
            if (text.isEmpty() || doc.getCode().toLowerCase().contains(text)
                    || doc.getName().toLowerCase().contains(text)
                    || doc.getSpecialization().toLowerCase().contains(text)
                    || String.valueOf(doc.getAvailability()).contains(text)) {
                result.add(doc);
            }
        }
        return result;
    }

    private static boolean isCodeExists(String code) {
        return doctors.stream().anyMatch(d -> d.getCode().equalsIgnoreCase(code));
    }

}
