import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    public static void main(String[] args) {
        // Checked Exceptions
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();

        // Unchecked Exceptions
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // 1. IOException
    private static void handleIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent_file.txt"));
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    private static void handleFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    private static void handleEOFException() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("example.dat"))) {
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (EOFException e) {
            System.err.println("EOFException caught: End of file reached.");
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }
    }

    // 4. SQLException
    private static void handleSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistent_db", "root", "password");
        } catch (SQLException e) {
            System.err.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    private static void handleClassNotFoundException() {
        try {
            Class.forName("com.missing.ClassName");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // 6. ArithmeticException
    private static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    private static void handleNullPointerException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    private static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    private static void handleClassCastException() {
        try {
            Object obj = "String";
            Integer number = (Integer) obj; // Invalid cast
        } catch (ClassCastException e) {
            System.err.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException
    private static void handleIllegalArgumentException() {
        try {
            setAge(-1); // Invalid argument
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    // 11. NumberFormatException
    private static void handleNumberFormatException() {
        try {
            int number = Integer.parseInt("invalid_number");
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
