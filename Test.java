package CourseRegistrationSystem;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<Student>();
        for(int i = 0; i < 10; i++) {
            students.add(new Student(20212905006L+i, "Kaan"+(i+1), "Akkök"+(i+1)));
        }

        ArrayList<Course> semesterCourses = new ArrayList<Course>();
        semesterCourses.add(new Course("ACM321", "Object orianted programing", "Monday", 12, 15, 5));
        semesterCourses.add(new Course("ACM262", "İntroduction to web design", "Tuesday", 9, 12, 5));       
        semesterCourses.add(new Course("STAT410", "Statistic", "Thursday", 13, 16, 5));
        semesterCourses.add(new Course("TKL201", "Turkish language 1", "Monday", 10, 13, 5));
        semesterCourses.add(new Course("ACM222", "Structural programing", "Thursday",15, 18, 5));
        semesterCourses.add(new Course("ACM212", "Advanced database applications", "Wednesday", 9, 12, 5));
        semesterCourses.add(new Course("ACM311", "Visual programming", "Friday", 10, 13, 5));
        semesterCourses.add(new Course("COMP202", "Design patterns", "Wednesday", 11, 14, 5));
        semesterCourses.add(new Course("COMP203", "Computer networks", "friday", 9, 12, 5));
        semesterCourses.add(new Course("TKL202", "Turkish language 2", "Tuesday", 16, 19, 5));

        //add courses.
        for(int i = 0; i < students.size(); i++) {
            for(int j = 0; j < semesterCourses.size(); j++) {
                students.get(i).addCourse(semesterCourses.get(j));
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }

        System.out.println("\n\n\n");
        System.out.println("----------------------------------------------------------------------------------------");

        for(int i = 0; i < semesterCourses.size(); i++) {
            System.out.println(semesterCourses.get(i).getcourseCode() + ":" + semesterCourses.get(i).getenrolledStudent());
        }

        System.out.println("\n\n\n");
        System.out.println("----------------------------------------------------------------------------------------");

        // drop courses.
        for(int i = 0; i < students.size(); i++) {
            for(int j = 0; j < semesterCourses.size(); j++) {
                students.get(i).dropCourse(semesterCourses.get(j));
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }

        System.out.println("\n\n\n");
        System.out.println("----------------------------------------------------------------------------------------");

        for(int i = 0; i < semesterCourses.size(); i++) {
            System.out.println(semesterCourses.get(i).getcourseCode() + ":" + semesterCourses.get(i).getenrolledStudent());
        }
    }
}
