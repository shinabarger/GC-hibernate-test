package com.test.controller;

import com.test.models.CustomersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        return new
                ModelAndView("welcome", "message", "HELLO WORLD!");

    }

    @RequestMapping("welcome")

    public ModelAndView helloWorld2() {
        int[] ar = {1, 2, 3, 4};

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session selectCustomers = sessionFactory.openSession();

        selectCustomers.beginTransaction();

        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

        ArrayList<CustomersEntity> customerList = (ArrayList<CustomersEntity>) c.list();

        return new
                ModelAndView("welcome2", "cList", customerList);

    }

}
