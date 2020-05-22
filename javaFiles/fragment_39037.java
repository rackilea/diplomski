import java.lang.annotation.*;
import java.util.*;

@Inherited
@Repeatable(Container.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann {
    String value();
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Container {
    Ann[] value();
}

// Basic case. Result is that
// only @Ann("2") is present on
// ExhibitASub.
@Ann("1")
class ExhibitASuper {
}
@Ann("2")
class ExhibitASub extends ExhibitASuper {
}

// Because this case results in the
// @Container being present on ExhibitBSuper,
// rather than @Ann, all three annotations
// end up appearing on ExhibitBSub.
@Ann("1")
@Ann("2")
class ExhibitBSuper {
}
@Ann("3")
class ExhibitBSub extends ExhibitBSuper {
}

// Similar to the preceding case, by
// forcing the use of @Container, both
// annotations are present on ExhibitCSub.
@Container(@Ann("1"))
class ExhibitCSuper {
}
@Ann("2")
class ExhibitCSub extends ExhibitCSuper {
}

// Yet when we force both to use @Container,
// only @Container(@Ann("2")) is present on
// ExhibitDSub.
@Container(@Ann("1"))
class ExhibitDSuper {
}
@Container(@Ann("2"))
class ExhibitDSub extends ExhibitDSuper {
}

class Main {
    public static void main(String[] args) {
        for (Class<?> cls : Arrays.asList(ExhibitASub.class,
                                          ExhibitBSub.class,
                                          ExhibitCSub.class,
                                          ExhibitDSub.class)) {
            System.out.printf("%s:%n", cls);
            for (Annotation ann : cls.getAnnotations()) {
                System.out.printf("    %s%n", ann);
            }

            System.out.println();
        }
    }
}