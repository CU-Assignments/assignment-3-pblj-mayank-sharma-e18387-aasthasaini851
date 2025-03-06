// UniversityEnrollment.java
import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class University {
    private HashMap<String, Boolean> completedCourses = new HashMap<>();

    public void completeCourse(String course) {
        completedCourses.put(course, true);
    }

    public void enroll(String course, String prerequisite, boolean isFull) throws CourseFullException, PrerequisiteNotMetException {
        if (isFull) {
            throw new CourseFullException("Error: CourseFullException - " + course + " is already full.");
        }
        if (!completedCourses.getOrDefault(prerequisite, false)) {
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course);
        }

        System.out.println("Successfully enrolled in " + course);
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();

        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();
        System.out.print("Prerequisite: ");
        String prerequisite = scanner.nextLine();

        try {
            university.enroll(course, prerequisite, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
