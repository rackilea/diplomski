import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.classify.Classifier;

public class ClassifierCompositeLineMapperTest {

    private ClassifierCompositeLineMapper compositeLineMapper;

    @Before
    public void setUp() {
        Classifier<String, LineMapper<?>> classifier = new Classifier<String, LineMapper<? extends Object>>() {
            @Override
            public LineMapper<?> classify(String classifiable) {
                if (classifiable.contains("Class1")) {
                    return new Class1LineMapper();
                }

                if (classifiable.contains("Class2")) {
                    return new Class2LineMapper();
                }
                return new PassThroughLineMapper(); // or any other default line mapper
            }
        };
        compositeLineMapper = new ClassifierCompositeLineMapper(classifier);
    }

    @Test
    public void mapLine() throws Exception {
        Object line1 = compositeLineMapper.mapLine("00|0|56||Class1|25|001|0", 1);
        Assert.assertTrue(line1 instanceof Class1);
        Object line2 = compositeLineMapper.mapLine("02|23|11||Class2|65|ENG|ENG|", 2);
        Assert.assertTrue(line2 instanceof Class2);
    }

    static class Class1 {}
    static class Class1LineMapper implements LineMapper<Class1> {

        @Override
        public Class1 mapLine(String line, int lineNumber) throws Exception {
            return new Class1(); // TODO mapping logic
        }
    }

    static class Class2 {}
    static class Class2LineMapper implements LineMapper<Class2> {

        @Override
        public Class2 mapLine(String line, int lineNumber) throws Exception {
            return new Class2(); // TODO mapping logic
        }
    }

}