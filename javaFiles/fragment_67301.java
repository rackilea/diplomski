import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.reactfx.value.Val;
import org.reactfx.value.Var;

class TestBean {

    private final StringProperty testProperty = new SimpleStringProperty();
    public final StringProperty testPropertyProperty()        { return testProperty; }
    public final String getTestProperty()                     { return testProperty.get(); }
    public final void setTestProperty(String newTestProperty) { testProperty.set(newTestProperty); }
}

public class SomeType {

    private final ObjectProperty<TestBean> property = new SimpleObjectProperty<>();
    public final ObjectProperty<TestBean> propertyProperty() { return property; }
    public final TestBean getProperty()                      { return property.get(); }
    public final void setProperty(TestBean newProperty)      { property.set(newProperty); }

    public static void main(String[] args) {
        SomeType someType = new SomeType();
        Var<String> chainedTestProperty = Val.selectVar(someType.propertyProperty(), TestBean::testPropertyProperty);
        chainedTestProperty.addListener((obs, oldVal, newVal) -> System.out.println(obs + " " + oldVal + "->" + newVal));

        //Tests
        someType.setProperty(new TestBean());
        someType.getProperty().setTestProperty("s1");
        TestBean bean2 = new TestBean();
        bean2.setTestProperty("s2");
        someType.setProperty(bean2);
        someType.setProperty(new TestBean());
    }
}