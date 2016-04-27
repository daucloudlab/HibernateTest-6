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

        Meeting meeting1 = new Meeting("Театрда кесдесу") ;
        Meeting meeting2 = new Meeting("Кітапханада кездесу") ;

        Employee employee1 = new Employee("Дәулет", "Баймбетов") ;
        Employee employee2 = new Employee("Әлия", "Анарбекова") ;

        employee1.getMeetings().add(meeting1) ;
        employee1.getMeetings().add(meeting2) ;
        employee2.getMeetings().add(meeting1) ;

        session.save(employee1) ;
        session.save(employee2) ;

        tx.commit();
        session.close() ;

    }
}
