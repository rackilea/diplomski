package com.x.dao;
import com.x.model.Emp;

@Component
public class EmpDao {

public void saveEmpObj(Emp emp) {
    System.out.println(emp.getEname());
          System.out.println("===============>Emp Dao Called<==================");
}
}