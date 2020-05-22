package com.stackoverflow.q35269763;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test {

    public static void main(String... args) throws Exception {
        DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(Test.class.getClassLoader())
            .setDeploymentName("myapp").setContextPath("/myapp")
            .addServlets(Servlets.servlet("myservlet",
                new HttpServlet() {
                    @Override
                    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        response.getWriter().write("Hello World!");
                    }
                }.getClass()).addMapping("/myservlet"));
        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/myapp")).addPrefixPath("/myapp", manager.start());
        Undertow server = Undertow.builder().addHttpListener(8888, "localhost").setHandler(path).build();
        server.start();
    }

}