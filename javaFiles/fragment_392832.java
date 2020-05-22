public interface HasTitle {
    public String getTitle();
}

public class MyClass1 implements HasTitle {
    // ...

    @Override
    public String getTitle() {
        return this.title;
    }
}

public class MyClass2 implements HasTitle {
    // ...

    @Override
    public String getTitle() {
        return this.title;
    }
}

...

/**
 * This method can be invoked withg a List<MyClass1> or with a List<MyClass2>
 * as argument, since MyClass1 and MyClass2 both implement HasTitle
 */
public void displayTitles(List<? extends HasTitle> entities) {
    for (HasTitle entity : entities) {
        out.println(entity.getTitle();
    }
}