package main;

public class Staff extends Person implements IsStaff {

    @Override
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public Integer getStaffId() {
        return staffId;
    }

}



package main;

public class Student extends Person implements IsStudent {

    @Override
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public Integer getStudentId() {
        return studentId;
    }

}