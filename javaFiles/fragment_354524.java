package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaCircularReferenceTestApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaCircularReferenceTestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaCircularReferenceTestApplication.class, args);

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Employee emp1 = new Employee("EMP1");
        Employee emp2 = new Employee("EMP2");
        Employee emp3 = new Employee("EMP3");
        Employee emp4 = new Employee("EMP4");

        Employee director1 = new Employee("DIRECTOR1", emp1, emp2);
        Employee director2 = new Employee("DIRECTOR2", emp3, emp4);

        Employee vp1 = new Employee("VP1", director1);
        Employee vp2 = new Employee("VP2", director2);

        Employee ceo = new Employee("CEO", vp1, vp2);

        vp1.setManager(ceo);
        vp2.setManager(ceo);

        director1.setManager(vp1);
        director2.setManager(vp2);

        emp1.setManager(director1);
        emp2.setManager(director1);
        emp3.setManager(director2);
        emp4.setManager(director2);

        employeeRepository.save(ceo);

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        LOGGER.info("Is {} direct manager of {}? {}", "CEO", "VP1", employeeService.isManagerOf("CEO", "VP1"));
    }
}