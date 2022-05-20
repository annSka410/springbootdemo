package com.example.springbootdemo.manager;

import com.example.springbootdemo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserManager {

    public static void main(String[] args) {

        SessionFactory sf = builtSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setFirstName("Yuliya");
        user.setLastName("Rusanova");

        Long id = (Long) session.save(user);
        System.out.println(id);

        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory builtSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable exception) {
            System.err.println("Initial SessionFactory creation failed. " + exception);
            throw new ExceptionInInitializerError(exception);
        }
    }
}
