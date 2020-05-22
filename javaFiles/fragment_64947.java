public class Class {
    public final static String MATH = "Math";
    public final static String CHEMISTRY = "Chemistry";
    public final static String PHYSICS = "Physics";

    private String pName;


    private String pDepartment;
    private int pNumberCredits;
    private double grade;

    public Class(String pName, String pDepartment, int pNumberCredits) {
        this.pName = pName;
        this.pDepartment = pDepartment;
        this.pNumberCredits = pNumberCredits;
        this.grade = -1;
    }

    /**
     * @return the pName
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName the pName to set
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * @return the pDepartment
     */
    public String getpDepartment() {
        return pDepartment;
    }

    /**
     * @param pDepartment the pDepartment to set
     */
    public void setpDepartment(String pDepartment) {
        this.pDepartment = pDepartment;
    }

    /**
     * @return the pNumberCredits
     */
    public int getpNumberCredits() {
        return pNumberCredits;
    }

    /**
     * @param pNumberCredits the pNumberCredits to set
     */
    public void setpNumberCredits(int pNumberCredits) {
        this.pNumberCredits = pNumberCredits;
    }

    /**
     * @return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}