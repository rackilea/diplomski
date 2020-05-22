public class MyBase{}
public class MyDerived extends MyBase{}
public class SomeOtherDerived extends MyBase{}
public static <T extends MyBase> T getAnything(){ return (T)new MyDerived(); }

public static void main(String[] args) {
    SomeOtherDerived instance = getAnything(); //This is legal and bad
}