import org.hibernate.Session;


public class Appinitializer {

    public static void main(String[] args) {

            printMysqlVersion();
            printMysqlDateAndTime();




    }

    private static void printMysqlDateAndTime(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Object result = session.createNativeQuery("SELECT NOW()").getSingleResult();
            System.out.println(result);
        }
    }

    private static void printMysqlVersion(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Object result = session.createNativeQuery("SELECT VERSION()").getSingleResult();
            System.out.println(result);
        }
    }
}
