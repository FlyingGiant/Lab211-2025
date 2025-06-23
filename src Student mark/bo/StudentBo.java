package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentBo {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void createStudent() {
        Student student = Student.inputStudent();
        studentList.add(student);
    }

    public static double[] getPercentTypeStudent() {
        int total = studentList.size();
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (Student s : studentList) {
            switch (s.getType()) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
            }
        }

        return new double[] {
                (countA * 100.0) / total,
                (countB * 100.0) / total,
                (countC * 100.0) / total,
                (countD * 100.0) / total
        };

    }

    public static boolean checkYesNo(String choice) {
        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Student> getAllStudents() {
        return studentList;
    }
}
