public enum ElementType {

    DARK,
    LIGHT // ...
}

public class Element {
    String name;
    Map<ElementType, Double> multipliers = ...;

    // ...

    public Builder vulnerability(ElementType... elementTypes) {
        for (ElementType elementType : elementTypes) {
            multipliers.put(elementType , 2.0);
        }
        return this;
    }
}


Element nora = new Element.Builder("Nora").vulnerability(ElementType.DARK, ElementType.LIGHT).create();