package entity;


import javax.persistence.*;

//@Entity(name = "student_table")

@Entity
//@Table(name = "student_table")
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.Auto)   //store next value in another class
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //not create another class do in that internally
    @Column(name = "id")
    public long studentId;

    @Column(name = "name", length = 45, nullable = false)
    private String studentName;

    private double marks;

    public Student() {
    }

    public Student(long studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
