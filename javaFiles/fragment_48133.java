package com.example.guestbook;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestbookServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity entity0 = new Entity("Dummy", "abc");
        entity0.setProperty("created", new Date());
        datastore.put(entity0);
        Entity entity1 = new Entity("Dummy", "xyz");
        entity1.setProperty("created", null);
        datastore.put(entity1);
    }
}