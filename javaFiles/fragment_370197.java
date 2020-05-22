public class ClassX {

public int classId;

public ClassX(int id) {
    this.classId = id;
}

public void setId(int id) {
    classId = id;
}

public int getId() {
    return classId;
}
}


public class ClassY {
public static void main(String[] args) {
    ClassX cx = new ClassX(100);
    ClassY cy = new ClassY();

    System.out.println("classId:"+cx.classId);
    cy.modifyId(cx); // an object is passed as argument to a method
    System.out.println("classId:"+cx.classId);

}

public void modifyId(ClassX classx) {
    classx.setId(220);
}
}