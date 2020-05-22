package mcve.reflect;

import static mcve.reflect.MCVEReflect.*;

import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.util.stream.Collectors.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MCVEReflectTest {
    public MCVEReflectTest() {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface AnnoContainer {
        Anno[] value();
    }

    @Repeatable(AnnoContainer.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Anno {
        String value();
    }

    interface I {
        @Anno("I.m")
        void m();
    }
    interface J extends I {
        @Anno("J.m")
        @Override
        void m();
    }
    interface K {
        @Anno("K.m")
        void m();
    }

    @Test
    public void getAnnotationsTest() throws NoSuchMethodException {
        try {
            getAnnotations(null, Anno.class);
            fail();
        } catch (NullPointerException x) {
        }
        try {
            getAnnotations(List.class.getMethod("size"), null);
            fail();
        } catch (NullPointerException x) {
        }

        class A {
            @Anno("A.m")
            void m() {}
            @Anno("A.m(int)")
            void m(int a) {}
        }
        class B extends A implements K {
            @Anno("B.m 1")
            @Anno("B.m 2")
            @Override
            public void m() {}
        }
        class C extends B implements J {
            @Anno("C.m")
            @Override
            public void m() {}
        }

        System.out.println(Arrays.toString(B.class.getInterfaces()));

        List<Anno>   annos;
        List<String> expect;
        List<String> actual;

        annos  = getAnnotations(A.class.getDeclaredMethod("m"), Anno.class);
        expect = Arrays.asList("A.m");
        actual = annos.stream().map(Anno::value).collect(toList());

        assertEquals(expect, actual);

        annos  = getAnnotations(B.class.getDeclaredMethod("m"), Anno.class);
        expect = Arrays.asList("B.m 1", "B.m 2", "A.m", "K.m");
        actual = annos.stream().map(Anno::value).collect(toList());

        assertEquals(expect, actual);

        annos  = getAnnotations(C.class.getDeclaredMethod("m"), Anno.class);
        expect = Arrays.asList("C.m", "B.m 1", "B.m 2", "A.m", "J.m", "I.m", "K.m");
        actual = annos.stream().map(Anno::value).collect(toList());

        assertEquals(expect, actual);

        annos  = getAnnotations(J.class.getDeclaredMethod("m"), Anno.class);
        expect = Arrays.asList("J.m", "I.m");
        actual = annos.stream().map(Anno::value).collect(toList());

        assertEquals(expect, actual);

        annos = getAnnotations(Object.class.getMethod("toString"), Anno.class);
        assertEquals(Collections.emptyList(), annos);
    }

    private boolean overrides(Method a, Method b) {
        return MCVEReflect.overrides(a, b);
    }

    private boolean overrides(Class<?> classA, String nameA,
                              Class<?> classB, String nameB)
            throws NoSuchMethodException {
        return MCVEReflect.overrides(classA.getDeclaredMethod(nameA),
                                     classB.getDeclaredMethod(nameB));
    }

    private boolean overrides(Class<?> classA, Class<?> classB, String name)
            throws NoSuchMethodException {
        return overrides(classA, name, classB, name);
    }

    @Test
    public void overridesTest() throws NoSuchMethodException {
        try {
            overrides(null, List.class.getMethod("size"));
            fail();
        } catch (NullPointerException x) {
        }
        try {
            overrides(List.class.getMethod("size"), null);
            fail();
        } catch (NullPointerException x) {
        }

        assertTrue("this is an override", overrides(ArrayList.class, "size",  List.class, "size"));
        assertFalse("same method",        overrides(List.class,      "size",  List.class, "size"));
        assertFalse("different methods",  overrides(ArrayList.class, "clear", List.class, "size"));

        class A { private void m() {} }
        class B extends A { private void m() {} }

        assertFalse("private methods", overrides(B.class, "m", A.class, "m"));

        class C { public void m() {} }
        class D { public void m() {} }

        assertFalse("no inheritance", overrides(D.class, "m", C.class, "m"));

        class E { public void m() {} }
        class F { public void m() {} }
        class G extends F { @Override public void m() {} }

        assertTrue("yes inheritance", overrides(G.class, "m", F.class, "m"));
        assertFalse("no inheritance", overrides(G.class, "m", E.class, "m"));

        class H {
            public void m(char a) {}
            public void m(long a) {}
        }
        class I extends H {
            @Override public void m(char a) {}
            @Override public void m(long a) {}
        }

        assertTrue("same parameters",
                   overrides(I.class.getDeclaredMethod("m", char.class),
                             H.class.getDeclaredMethod("m", char.class)));
        assertFalse("different parameters",
                    overrides(I.class.getDeclaredMethod("m", char.class),
                              H.class.getDeclaredMethod("m", long.class)));

        class SubHashMap extends HashMap<Object, Object> {
            void reinitialize() {
            }
        }

        String reinitialize = "reinitialize";
        // if this throws, find another method as a replacement
        Method m = HashMap.class.getDeclaredMethod(reinitialize);
        assertTrue(isPackageAccess(m.getModifiers()));
        assertFalse(Modifier.isFinal(m.getModifiers()));

        assertFalse("would override, except they are in different packages",
                    overrides(SubHashMap.class, HashMap.class, reinitialize));
    }

    @Test
    public void compareAccessTest() {
        assertEquals( 0, compareAccess(Modifier.PUBLIC,    Modifier.PUBLIC));
        assertEquals(+1, compareAccess(Modifier.PUBLIC,    Modifier.PROTECTED));
        assertEquals(+1, compareAccess(Modifier.PUBLIC,    0));
        assertEquals(+1, compareAccess(Modifier.PUBLIC,    Modifier.PRIVATE));
        assertEquals(-1, compareAccess(Modifier.PROTECTED, Modifier.PUBLIC));
        assertEquals( 0, compareAccess(Modifier.PROTECTED, Modifier.PROTECTED));
        assertEquals(+1, compareAccess(Modifier.PROTECTED, 0));
        assertEquals(+1, compareAccess(Modifier.PROTECTED, Modifier.PRIVATE));
        assertEquals(-1, compareAccess(0,                  Modifier.PUBLIC));
        assertEquals(-1, compareAccess(0,                  Modifier.PROTECTED));
        assertEquals( 0, compareAccess(0,                  0));
        assertEquals(+1, compareAccess(0,                  Modifier.PRIVATE));
        assertEquals(-1, compareAccess(Modifier.PRIVATE,   Modifier.PUBLIC));
        assertEquals(-1, compareAccess(Modifier.PRIVATE,   Modifier.PROTECTED));
        assertEquals(-1, compareAccess(Modifier.PRIVATE,   0));
        assertEquals( 0, compareAccess(Modifier.PRIVATE,   Modifier.PRIVATE));
        int notModsL = Modifier.PRIVATE | Modifier.PUBLIC;
        int notModsR = Modifier.PRIVATE | Modifier.PROTECTED;
        assertEquals("this might as well be undefined, but it's here for posterity",
                     0, compareAccess(notModsL, notModsR));
    }
}