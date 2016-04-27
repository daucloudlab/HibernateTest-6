package kz.tezdet.lessons.hibernate.main;


import kz.tezdet.lessons.hibernate.models.Employee;
import kz.tezdet.lessons.hibernate.models.Meeting;
import kz.tezdet.lessons.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession() ;
        Transaction tx = session.beginTransaction() ;

        Meeting meeting1 = new Meeting("Quaterly Sales meeting") ;
        Meeting meeting2 = new Meeting("Weekly Status meeting") ;

        Employee employee1 = new Employee("Sergey", "Brin") ;
        Employee employee2 = new Employee("Larry", "Page") ;

        employee1.getMeetings().add(meeting1) ;
        employee1.getMeetings().add(meeting2) ;
        employee2.getMeetings().add(meeting1) ;

        session.save(employee1) ;
        session.save(employee2) ;

        tx.commit();
        session.close() ;

    }
}
