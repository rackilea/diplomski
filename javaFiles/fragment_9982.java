class ClassToInitialize {
    static {
        staticField = ParamPassClass.getParameter();
    }

    private static String staticField;

    ClassToInitialize() {
        System.out.println("This is the parameter: " + staticField);
    }

}

class ParamPassClass {
    private static String parameter;
    static String getParameter() {
        return parameter;
    }

    static void setParameter(String parameter) {
        ParamPassClass.parameter = parameter;
    }
}

class Main {
    public static void main(String args[]) {
        ParamPassClass.setParameter("Test param");
        new ClassToInitialize();
    }
}