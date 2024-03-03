package CourseRegistrationSystem;

import java.util.ArrayList;

public class Student {
    long studentNum;
    String studentName;
    String studentSurname;
    ArrayList<Course> choisedCourses;

    public Student(long studentNum, String studentName, String studentSurname) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        choisedCourses = new ArrayList<Course>();
    }   

    private int studentLimit() {
        if (choisedCourses.size() < 5) {
            return 2;
        }
        return 1;
    }

    private int courseLimit(Course newCourse) {
        if (newCourse.getenrolledStudent() < newCourse.getmaxEnrolled()) {
            return 2;
        }
        return 1;
    }

    private int hasConflictSchedule(Course newCourse) {
        for (Course enrolledCourse : choisedCourses) {
            if (enrolledCourse.getday().equals(newCourse.getday())) {
                if (enrolledCourse.getstartTime() <= newCourse.getstartTime() && newCourse.getstartTime() < enrolledCourse.getfinishTime()) {
                    return 1;
                } 
                else if (enrolledCourse.getstartTime() < newCourse.getfinishTime() && newCourse.getfinishTime() <= enrolledCourse.getfinishTime()) {
                    return 1;
                }
            }
        }
        return 2;
    }

    public void addCourse(Course newCourse) {
        switch (studentLimit()) {
            case 1:
                System.out.println(studentName + " " + studentSurname + " named student can not add ---> " + newCourse.getcourseName() + "(" + newCourse.getcourseCode() + ")");
                System.out.println("Reason: The student has reached the limit! (max 5 courses you can select)");
                break;
            case 2:
                switch (courseLimit(newCourse)) {
                    case 1:
                        System.out.println(studentName + " " + studentSurname + " named student can not add ---> " + newCourse.getcourseName() + "(" + newCourse.getcourseCode() + ")");
                        System.out.println("Reason: The course has reached the limit! (max 5 students can select the same course)");
                        break;
                    case 2:
                        switch (hasConflictSchedule(newCourse)) {
                            case 1:
                                System.out.println(studentName + " " + studentSurname + " named student can not add ---> " + newCourse.getcourseName() + "(" + newCourse.getcourseCode() + ")");
                                System.out.println("Reason: Student's course schedule conflicts!");
                                break;
                            case 2:
                                choisedCourses.add(newCourse);
                                newCourse.enrolledStudent++;
                                System.out.println(studentName + " " + studentSurname + " named student added ---> " + newCourse.getcourseName() + " (" + newCourse.getcourseCode() + ")");
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public void dropCourse(Course newCourse) {
        if (choisedCourses.contains(newCourse)) {
            newCourse.enrolledStudent--;
            choisedCourses.remove(newCourse);
            System.out.println(studentName + " " + studentSurname + " named student dropped ---> " + newCourse.getcourseName() + "(" + newCourse.getcourseCode() + ")");
        } 
        else {
            System.out.println(studentName + " " + studentSurname + " named student can not drop ---> " + newCourse.getcourseName() + "(" + newCourse.getcourseCode() + ")");
            System.out.println("Reason: Student doesn't have this course!");
        }
    }
}
