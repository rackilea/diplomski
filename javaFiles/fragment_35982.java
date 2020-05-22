public class Route {
    String studentName;
    boolean colorRed;

    public Route(String studentName, boolean colorRed) {
        this.studentName=studentName;
        this.colorRed=colorRed;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isColorRed() {
        return colorRed;
    }

    public void setColorRed(boolean colorRed) {
        this.colorRed = colorRed;
    }
}