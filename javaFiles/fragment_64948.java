public class CertificateGrades {


    private List<Class> classes = new ArrayList<Class>();

    public void addClass(Class clazz) {
        this.classes.add(clazz);
    }

    public CertificateGrades() {
        mockData();
    }

    /**
     * mock data
     * */
    public void mockData() {
        Class class1= new Class("APO1", Class.MATH, 3);
        Class class2= new Class("Calculus", Class.MATH, 3);
        Class class3= new Class("Organic", Class.CHEMISTRY, 3);
        Class class4= new Class("Lab", Class.PHYSICS, 1);
        classes.add(class1);
        classes.add(class2);
        classes.add(class3);
        classes.add(class4);
    }

    public int giveNumberClassesDepartment( String pDepartment )
    {
        int result = 0;
        for (Class clazz : classes) {
            if(clazz.getpDepartment().equals(pDepartment)) {
                result++;
            }
        }
        return result;

    }
}