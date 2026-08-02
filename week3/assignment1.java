import java.util.ArrayList;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(75);
        marks.add(88);
        marks.add(92);
        marks.add(67);
        marks.add(81);

        int highest = marks.get(0);
        int lowest = marks.get(0);

        for (int mark : marks) {
            if (mark > highest)
                highest = mark;
            if (mark < lowest)
                lowest = mark;
        }

        System.out.println("Marks: " + marks);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
    }
}
