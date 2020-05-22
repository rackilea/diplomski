public class MyBean {
    Integer someInt;
    Double someDoub;

    public Integer getSomeInt(){
        if (someInt == null) someInt = GeneratorUtil.createAndEvaluate();
        return someInt;
    }

    public Double getSomeDoub(){
        if (someDoub == null) someDoub = GeneratorUtil().createAndEvaluate();
        return someDoub;
    }
}

public class GeneratorUtil {
    @SuppressWarnings("unchecked")
    public static <T> T createAndEvaluate() {
        return (T) new Generator().evaluate();
    }
}