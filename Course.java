package CourseRegistrationSystem;

public class Course {

    String courseCode;
    String courseName;
    String day;
    int startTime;
    int finishTime;
    int maxEnrolled;
    int enrolledStudent;
    
    public Course(String courseCode, String courseName, String day, int startTime, int finishTime, int maxEnrolled) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.day = day;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.maxEnrolled = maxEnrolled;
        enrolledStudent = 0;
    }

    public String getcourseName() {
        return courseName;
    }

    public String getcourseCode() {
        return courseCode;
    }

    public String getday() {
        return day;
    }

    public int getstartTime() {
        return startTime;
    }

    public int getfinishTime() {
        return finishTime;
    }

    public int getenrolledStudent() {
        return enrolledStudent;
    }

    public int getmaxEnrolled() {
        return maxEnrolled;
    }
}
