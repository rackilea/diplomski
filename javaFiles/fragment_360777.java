package domain.app;

import org.hibernate.Session;

import domain.app.data.History;
import domain.app.data.Student;
import domain.app.data.util.HibernateUtil;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession().openSession();
        session.getTransaction().begin();

        Student student = new Student();
        History history1 = new History();
        history1.setSomeAttribute("Volunteer since 2016");

        History history2 = new History();
        history2.setSomeAttribute("Football team member");

        student.getHistory().add(history1);
        student.getHistory().add(history2);

        session.save(student);
        session.getTransaction().commit();
        session.close();

    }

}