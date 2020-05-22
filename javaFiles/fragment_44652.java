package com.vc.teacher.db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.vc.teacher.entities.User;
@Component
public class UserDao {


@Autowired
SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
    return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
}

@Transactional
public User checkCreditionals(String email, String password){
    User user = null;
    Session session  =  sessionFactory.getCurrentSession();
    Query query =   session.createQuery("from User where email = '"+email+"' and password = '"+password+"'");
    List list   =   query.list();
    if(list.size()>0)
        user =  (User)list.get(0);

    return user;
}

@Transactional
public boolean registerUser(User user){
    boolean result = false;
    Session session = sessionFactory.getCurrentSession();
    try{
        user.setUserTypeId(2);
        session.save(user);

        result = true;
    } catch (Exception e){
        result = false;
        e.printStackTrace();
    }

    return result;
}

}`