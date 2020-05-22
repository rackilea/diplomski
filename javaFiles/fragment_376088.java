package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {
    @Autowired
    private StringValidator stringValidator;

    public void main() {
        stringValidator.validate();
        final List<String> validatedList = stringValidator.getValidatedList();
        for (String currentValid : validatedList) {
            System.out.println(currentValid);
        }
    }

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/META-INF/spring/applicationContext.xml");
        container.getBean(Main.class).main();
    }
}