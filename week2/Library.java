import java.util.*;

abstract class Person {
    protected String name;
    protected String id;
    
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public abstract void displayInfo();
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private String borrowedBy;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.borrowedBy = null;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getBorrowedBy() {
        return borrowedBy;
    }
    
    public boolean borrowBook(String userId) {
        if (available) {
            available = false;
            borrowedBy = userId;
            return true;
        }
        return false;
    }
    
    public boolean returnBook() {
        if (!available) {
            available = true;
            borrowedBy = null;
            return true;
        }
        return false;
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        if (available) {
            System.out.println("Status: Available");
        } else {
            System.out.println("Status: Borrowed by " + borrowedBy);
        }
        System.out.println("------------------------");
    }
}

class User extends Person {
    private String email;
    private int booksBorrowed;
    private static final int MAX_BOOKS = 3;
    
    public User(String name, String id, String email) {
        super(name, id);
        this.email = email;
        this.booksBorrowed = 0;
    }
    
    public String getId() {
        return id;
    }
    
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
    
    public boolean canBorrow() {
        return booksBorrowed < MAX_BOOKS;
    }
    
    public void incrementBorrowed() {
        booksBorrowed++;
    }
    
    public void decrementBorrowed() {
        if (booksBorrowed > 0) {
            booksBorrowed--;
        }
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Books Borrowed: " + booksBorrowed + "/" + MAX_BOOKS);
        System.out.println("------------------------");
    }
}

class Library {
    private String name;
    private List<Book> books;
    private Map<String, User> users;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }
    
    public void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        books.add(book);
        System.out.println("Book added: " + title);
    }
    
    public void registerUser(String name, String id, String email) {
        User user = new User(name, id, email);
        users.put(id, user);
        System.out.println("User registered: " + name);
    }
    
    public void borrowBook(String userId, String isbn) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("Error: User not found");
            return;
        }
        
        if (!user.canBorrow()) {
            System.out.println("Error: User has reached maximum book limit");
            return;
        }
        
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.borrowBook(userId)) {
                    user.incrementBorrowed();
                    System.out.println("Book borrowed: " + book.getTitle() + " by " + user.name);
                    return;
                } else {
                    System.out.println("Error: Book is not available");
                    return;
                }
            }
        }
        System.out.println("Error: Book not found");
    }
    
    public void returnBook(String userId, String isbn) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("Error: User not found");
            return;
        }
        
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getBorrowedBy() != null && book.getBorrowedBy().equals(userId)) {
                    book.returnBook();
                    user.decrementBorrowed();
                    System.out.println("Book returned: " + book.getTitle() + " by " + user.name);
                    return;
                } else {
                    System.out.println("Error: This book was not borrowed by this user");
                    return;
                }
            }
        }
        System.out.println("Error: Book not found");
    }
    
    public void displayAllBooks() {
        System.out.println("\n=== All Books in " + name + " ===");
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }
    
    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books available");
        }
    }
    
    public void displayAllUsers() {
        System.out.println("\n=== Registered Users ===");
        if (users.isEmpty()) {
            System.out.println("No users registered");
        } else {
            for (User user : users.values()) {
                user.displayInfo();
            }
        }
    }
}

// ============ MAIN CLASS ============
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("Central Library");
        
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===\n");
        
        // AI added book examplex because i was too bored to write it 
        System.out.println("Adding Books:");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "ISBN001");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "ISBN002");
        library.addBook("1984", "George Orwell", "ISBN003");
        library.addBook("Pride and Prejudice", "Jane Austen", "ISBN004");
        
        System.out.println("\n================================\n");
        
        System.out.println("Registering Users:");
        library.registerUser("ravi boy", "U001", "raviprogamer@email.com");
        library.registerUser("oy vaju", "U002", "veggies@email.com");
        
        System.out.println("\n================================\n");
        
        // Display all books
        library.displayAllBooks();
        
        System.out.println("\n================================\n");
        
        System.out.println("Borrowing Books:");
        library.borrowBook("U001", "ISBN001");
        library.borrowBook("U002", "ISBN002");
        library.borrowBook("U001", "ISBN003");
        library.borrowBook("U001", "ISBN004");
        
        System.out.println("\n================================\n");
        
        // Display available books
        library.displayAvailableBooks();
        
        System.out.println("\n================================\n");
        
        // Display users
        library.displayAllUsers();
        
        System.out.println("\n================================\n");
        
        // Returning books
        System.out.println("Returning Books:");
        library.returnBook("U001", "ISBN001");
        library.returnBook("U002", "ISBN002");
        
        System.out.println("\n================================\n");
        
        // Final status
        System.out.println("Final Library Status:");
        library.displayAllBooks();
        library.displayAllUsers();
    }
}
