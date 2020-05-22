package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean isManagerOf(String managerName, String employeeName) {
        Employee manager = employeeRepository.findByName(managerName);
        Employee employee = employeeRepository.findByName(employeeName);

        return manager.isDirectManagerOf(employee);
    }
}