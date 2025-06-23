package main;

import java.util.List;

import bo.StudentBo;
import entity.Student;
import utils.Validate;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Manage Student Program ======");
        while (true) {
            StudentBo.createStudent();
            String choice = Validate.getString("Do yo want to add more?(Y/N)", "Invalid choice",
                    "(?i)^(y|n|yes|no)$");
            if (!StudentBo.checkYesNo(choice)) {
                break;
            }
        }
        List<Student> students = StudentBo.getAllStudents();
        int count = 1;
        for (Student s : students) {
            System.out.println("------ Student" + count + " Info ------");
            System.out.println("Name: " + s.getName());
            System.out.println("Classes: " + s.getClassName());
            System.out.printf("AVG: %.1f\n", s.getAverage());
            System.out.println("Type: " + s.getType());
            count++;
        }

        double[] percents = StudentBo.getPercentTypeStudent();
        System.out.println("-------Classification Info -------");
        System.out.printf("A: %.1f%%\n", percents[0]);
        System.out.printf("B: %.1f%%\n", percents[1]);
        System.out.printf("C: %.1f%%\n", percents[2]);
        System.out.printf("D: %.1f%%\n", percents[3]);
        return;

    }
}