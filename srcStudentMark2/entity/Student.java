package entity;

public class Student {
    private String name;
    private String className;
    private double math;
    private double physic;
    private double chemistry;
    private double average;
    private String type;

    public Student() {
    }

    public Student(String name, String className, double math, double physic, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysic() {
        return physic;
    }

    public void setPhysic(double physic) {
        this.physic = physic;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void calculateAverageAndType() {
        average = (this.math + this.chemistry + this.physic) / 3;
        if (average > 7.5) {
            this.type = "A";
        } else if (average >= 6) {
            this.type = "B";
        } else if (average >= 4) {
            this.type = "C";
        } else {
            this.type = "D";
        }
    }

    public void displayInfo(int index){
        System.out.println("------ Student" + index + " Info ------");
        System.out.println("Name:" + name);
        System.out.println("Classes:" + className);
        System.out.printf("AVG: %.1f\n", average);
        System.out.println("Type:" + type);
    }
    // public Student inputStudent() {
    // String name = Validate.getString("Name:", "Invalid name",
    // "^(?!\\s*$)[A-Za-z0-9\\s]+$");
    // String className = Validate.getString("Classes: ", "Invalid class",
    // ".*\\S.*");
    // double math = Validate.getDouble("Math: ", "Math is greater than equal zero",
    // "Math is digit", 1, 10);
    // double physic = Validate.getDouble("Physic: ", "Physic is greater than equal
    // zero",
    // "Physic is digit", 1, 10);
    // double chemistry = Validate.getDouble("Chemistry: ", "Chemistry is greater
    // than equal zero",
    // "Chemistry is digit", 1, 10);
    // double average = (math + physic + chemistry) / 3;
    // char type;
    // if (average > 7.5) {
    // type = 'A';
    // } else if (average >= 6 && average <= 7.5) {
    // type = 'B';
    // } else if (average >= 4 && average < 6) {
    // type = 'C';
    // } else {
    // type = 'D';
    // }
    // return new Student(name, className, math, physic, chemistry, average, type);
    // }
}
