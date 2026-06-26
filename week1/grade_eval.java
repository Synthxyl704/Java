import java.util.Scanner;

public class GradeEvaluation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("eenter student marks (0-100): ");
        int marks = s.nextInt();
        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "fail!!!";
        }
        System.out.println("Grade: " + grade);
        s.close();
    }
}
