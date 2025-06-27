package main;

import java.util.ArrayList;
import java.util.List;

import bo.StudentBo;
import entity.Student;
import utils.Validate;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Manage Student Program ======");
        // StudentBo manager = new StudentBo();
        StudentBo manager = new StudentBo();
        List<Student> studentList = new ArrayList<>();

        while (true) {
            String name = Validate.getString("Name: ", "Invalid name!", "^[A-za-z0-9' -]+$"); // không để trống
            String className = Validate.getString("Classes: ", "Invalid class!", ".*\\S.*");

            double math = Validate.getDouble("Maths: ", "Maths is less than equal ten and greater than equal zero",
                    "Maths is digit", 0, 10);
            double chemistry = Validate.getDouble("Chemistry: ",
                    "Chemistry is less than equal ten and greater than equal zero", "Chemistry is digit", 0, 10);
            double physic = Validate.getDouble("Physics: ",
                    "Physics is less than equal ten and greater than equal zero", "Physics is digit", 0, 10);

            Student student = manager.createStudent(name, className, math, physic, chemistry);
            studentList.add(student);

            String choice = Validate.getString("Do you want to enter more student information?(Y/N): ",
                    "Invalid input! Enter Y or N.", "^[YyNn]$");
            if (choice.equalsIgnoreCase("N"))
                break;
        }
        manager.averageStudent(studentList);
        int index = 1;
        for (Student student : studentList) {
            student.displayInfo(index);
            index++;
        }

        double[] percents = manager.getPercentTypeStudent(studentList);
        System.out.println("-------Classification Info -------");
        System.out.printf("A: %.1f%%\n", percents[0]);
        System.out.printf("B: %.1f%%\n", percents[1]);
        System.out.printf("C: %.1f%%\n", percents[2]);
        System.out.printf("D: %.1f%%\n", percents[3]);

        // System.out.println("-------Classification Info -------");
        // HashMap<String, Double> stats = manager.getPercentTypeStudent(studentList);
        // for (String type : Arrays.asList("A", "B", "C", "D")) {
        //     System.out.printf("%s: %.1f%%\n", type, stats.get(type));
        // }





    }
}