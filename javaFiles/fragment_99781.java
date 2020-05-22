package com.example.vaadin.ex_formatinteger;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme ( "mytheme" )
public class MyUI extends UI {
    Person person;

    //@PropertyId ( "honorific" )
    final TextField honorific = new TextField ( "Honorific:" ); // Bean property.

    //@PropertyId ( "name" )
    final TextField name = new TextField ( "Full name:" ); // Bean property.

    // Manually bind property to field.
    final TextField yearOfBirthField = new TextField ( "Year of Birth:" ); // Bean property.

    final Label spillTheBeanLabel = new Label ( ); // Debug. Not a property.

    @Override
    protected void init ( VaadinRequest vaadinRequest ) {
        this.person = new Person ( "Ms.", "Margaret Hamilton", Integer.valueOf ( 1936 ) );

        Button button = new Button ( "Spill" );
        button.addClickListener ( ( Button.ClickEvent e ) -> {
            spillTheBeanLabel.setValue ( person.toString ( ) );
        } );

        // Binding
        Binder < Person > binder = new Binder <> ( Person.class );
        binder.forField ( this.yearOfBirthField )
              .withNullRepresentation ( "" )
              .withConverter ( new StringToIntegerConverter ( Integer.valueOf ( 0 ), "integers only" ) )
              .bind ( Person:: getYearOfBirth, Person:: setYearOfBirth );
        binder.bindInstanceFields ( this );
        binder.setBean ( person );


        setContent ( new VerticalLayout ( honorific, name, yearOfBirthField, button, spillTheBeanLabel ) );
    }

    @WebServlet ( urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true )
    @VaadinServletConfiguration ( ui = MyUI.class, productionMode = false )
    public static class MyUIServlet extends VaadinServlet {
    }
}