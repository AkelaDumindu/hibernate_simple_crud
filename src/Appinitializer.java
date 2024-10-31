import entity.Book;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Appinitializer {

    public static void main(String[] args) {
        Student student = new Student(1,"Akela Dumindu", 95);
//        saveStudent(student);
//        findStudent(1);
//        findAllStudent();
        updateStudentName("Dumindu", 1);
    }

    private static void saveStudent(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //save->it return a serializable object, saved object primary key
            //persist, saveOrUpdate
            Transaction transaction = session.beginTransaction();
            long primaryKey = (Long) session.save(student);
            transaction.commit();
            System.out.println(primaryKey);
        }
    }

    private static void saveBook(Book book){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            long primaryKey = (Long) session.save(book);
            System.out.println(primaryKey);
        }
    }

    private static void findStudent(long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Student student =session.find(Student.class,id);

            if (student != null){
                System.out.println(student.toString());
            }else {
                System.out.println("Can\'t find data");
            }
        }
    }

    private static void findAllStudent(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM student");
            List<Student> students = query.list();
            System.out.println(students);
        }
    }

    private static void updateStudentName(String name, long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Student selectedStudent = session.find(Student.class, id);
            if (selectedStudent!=null){
                selectedStudent.setStudentName(name);
                Transaction transaction = session.beginTransaction();
                session.update(selectedStudent);
                transaction.commit();
            }else{
                System.out.println("Can\'t find data");
            }
        }
    }

    

}
