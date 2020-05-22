package com.example.cssinject;

   import org.vaadin.cssinject.CSSInject;

   import com.vaadin.Application;
   import com.vaadin.ui.*;

    public class CssinjectApplication extends Application {
    @Override
    public void init() {

    final Window mainWindow = new Window("Cssinject Application");
    final Label label = new Label("Hello Vaadin user");
    mainWindow.addComponent(label);

    CSSInject css = new CSSInject();
    css.setValue(".custom-style { color: rgb(100, 200, 0); }");
    mainWindow.addComponent(css);

    label.setStyleName("custom-style");

    setMainWindow(mainWindow);  
}
}