import java.util.Scanner;

public class Student1 {
    private String name;
    private double average;

    public Student1(String name, double average) {
        this.name = name;
        if (average > 0.0 && average <= 100.0) {
            this.average = average;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAverage(double studentAverage) {
        if (studentAverage > 0.0 && studentAverage <= 100.0) {
            this.average = studentAverage;
        }
    }

    public double getAverage() {
        return average;
    }

    public String getLetterGrade() {
        String letterGrade = "";

        if (average >= 90.0)
            letterGrade = "A";
        else if (average >= 80.0)
            letterGrade = "B";
        else if (average >= 70.0)
            letterGrade = "C";
        else if (average >= 60.0)
            letterGrade = "D";
        else
            letterGrade = "F";

        return letterGrade;
    }

    public static void ClassAverage2() {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int gradeCounter = 1;

        while (gradeCounter <= 10) {
            System.out.print("Enter grade: ");
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }

        int average = total / 10;
        System.out.printf("%nTotal of all 10 grades is %d%n", total);
        System.out.printf("Class average is %d%n", average);
    }

    public static void Analysis1() {
        Scanner input = new Scanner(System.in);
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        while (studentCounter <= 10) {
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            int result = input.nextInt();

            if (result == 1)
                passes++;
            else
                failures++;

            studentCounter++;
        }

        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

        if (passes > 8)
            System.out.println("Bonus to instructor!");
    }

    public static void main(String[] args) {
        Student1 account1 = new Student1("Jane Green", 93.5);
        Student1 account2 = new Student1("John Blue", 72.75);

        System.out.printf("%s's letter grade is: %s%n", account1.getName(), account1.getLetterGrade());
        System.out.printf("%s's letter grade is: %s%n", account2.getName(), account2.getLetterGrade());

        // Calling the method to calculate class average
        System.out.println("ClassAverage:");
        Student1.ClassAverage2();

        // Calling the method to analyze results
        System.out.println("Analysis:");
        Student1.Analysis1();
    }
}
