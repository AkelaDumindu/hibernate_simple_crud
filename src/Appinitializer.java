import entity.Book;
import entity.Student;
import org.hibernate.Session;


public class Appinitializer {

    public static void main(String[] args) {
        Student student = new Student(1,"Akela Dumindu", 95);
        saveStudent(student);
    }

    private static void saveStudent(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //save->it return a serializable object, saved object primary key
            //persist, saveOrUpdate

            long primaryKey = (Long) session.save(student);
            System.out.println(primaryKey);
        }
    }

    private static void saveBook(Book book){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            long primaryKey = (Long) session.save(book);
            System.out.println(primaryKey);
        }
    }

}
