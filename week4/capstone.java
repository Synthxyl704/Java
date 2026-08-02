import java.util.ArrayList;

class Booking {
    int roomNo, days;
    String customer;

    Booking(int roomNo, String customer, int days) {
        this.roomNo = roomNo;
        this.customer = customer;
        this.days = days;
    }
}

public class HotelBooking {
    public static void main(String[] args) {
        ArrayList<Booking> bookings = new ArrayList<>();

        // Room rate per day
        int rate = 2000;

        // Add bookings
        bookings.add(new Booking(101, "Alice", 3));
        bookings.add(new Booking(102, "Bob", 2));

        // Cancel booking (Room 102)
        bookings.removeIf(b -> b.roomNo == 102);

        // Display bookings and total cost
        int totalCost = 0;
        System.out.println("Current Bookings:");
        for (Booking b : bookings) {
            int cost = b.days * rate;
            totalCost += cost;
            System.out.println("Room: " + b.roomNo +
                    ", Customer: " + b.customer +
                    ", Days: " + b.days +
                    ", Cost: ₹" + cost);
        }

        System.out.println("Total Cost: ₹" + totalCost);
    }
}
