public class Student {
    private String name;
    private int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }
}

public class HonorStudent extends Student {
    private int honorId;

    public HonorStudent(String name, int roll, int honorId) {
        super(name, roll);
        this.honorId = honorId;
    }

    public int getHonorId() {
        return honorId;
    }
}