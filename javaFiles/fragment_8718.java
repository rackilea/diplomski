package com.example.myapplication;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Theme("mytheme")
public class MyUI extends UI {

    public class Person implements Serializable {

        public Person(String name, int birthyear) {
            this.name = name;
            this.birthyear = birthyear;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBirthyear() {
            return birthyear;
        }

        public void setBirthyear(int birthyear) {
            this.birthyear = birthyear;
        }

        private String name;
        private int birthyear;
        }

    public class MyWindow extends Window implements Window.ResizeListener {
        final HorizontalLayout hLayout = new HorizontalLayout();

        public MyWindow() {
            setCaption("Grid");
            List<Person> people = Arrays.asList(
                new Person("Nicolaus Copernicus", 1543),
                new Person("Galileo Galilei", 1564),
                new Person("Johannes Kepler", 1571));

            Grid<Person> grid1 = new Grid<>();
            grid1.setItems(people);
            grid1.addColumn(Person::getName).setCaption("Name");
            grid1.addColumn(Person::getBirthyear).setCaption("Year of birth");
            grid1.setWidth("100%");

            VerticalLayout buttons = new VerticalLayout();

            Button button1 = new Button("<-");
            Button button2 = new Button("->");
            buttons.addComponents(button1,button2);
            buttons.setComponentAlignment(button1, Alignment.MIDDLE_CENTER);
            buttons.setComponentAlignment(button2, Alignment.MIDDLE_CENTER);

            Grid<Person> grid2 = new Grid<>();
            grid2.setItems(people);
            grid2.addColumn(Person::getName).setCaption("Name");
            grid2.addColumn(Person::getBirthyear).setCaption("Year of birth");
            grid2.setWidth("100%");

            hLayout.addComponents(grid1,buttons,grid2);
            hLayout.setExpandRatio(grid1, 3);
            hLayout.setExpandRatio(buttons, 1);
            hLayout.setExpandRatio(grid2, 3);
            hLayout.setWidth("100%");

            setContent(hLayout);
            setWidth("800px");
        }

        @Override
        public void windowResized(ResizeEvent e) {
            System.out.println("Window resized");
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        Label label = new Label("Window example");
        layout.addComponent(label);

        final MyWindow window = new MyWindow();

        addWindow(window);

        window.addResizeListener(event -> {
            Label lab = new Label("Window resized");
            layout.addComponent(lab);
        });

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}