class Student {
    String name;
    int rollNum;
    double grade;

    Student() {
        name = "synthxyl6769";
        rollNum = 67;
        grade = 6.767;
    }

    void returnInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("RN: " + rollNum);
        System.out.println("grade: " + grade);
    }
}

public class iso {
    static Student x = new Student();

    public static void main(String[] args) {
        x.returnInfo();
    }
} 
