package bo;

import entity.Student;
import java.util.*;

public class StudentBo {

    public Student createStudent(String name, String className, double maths, double chemistry, double physics) {
        return new Student(name, className, maths, chemistry, physics);
    }

    public List<Student> averageStudent(List<Student> students) {
        for (Student s : students) {
            s.calculateAverageAndType();
        }
        return students;
    }

    public double[] getPercentTypeStudent(List<Student> studentList) {
        int total = studentList.size();
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (Student s : studentList) {
            switch (s.getType()) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "C":
                    countC++;
                    break;
                case "D":
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

    // public HashMap<String, Double> getPercentTypeStudent1(List<Student> students)
    // {
    // HashMap<String, Integer> countMap = new HashMap<>();
    // countMap.put("A", 0);
    // countMap.put("B", 0);
    // countMap.put("C", 0);
    // countMap.put("D", 0);

    // for (Student s : students) {
    // countMap.put(s.getType(), countMap.get(s.getType()) + 1);
    // }

    // HashMap<String, Double> percentMap = new HashMap<>();
    // int total = students.size();
    // for (String type : countMap.keySet()) {
    // double percent = (countMap.get(type) * 100.0) / total;
    // percentMap.put(type, percent);
    // }

    // return percentMap;
    // }

    public static boolean checkYesNo(String choice) {
        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
}
