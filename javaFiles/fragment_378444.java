public interface I {
    public int evaluate( Supplier<Integer> s);
}

public static class A {

    public int getX(){return 5;}

    public int evaluateX(I model){

        return model.evaluate( () -> getX() );
    }
}

public static class Model implements I {

    @Override
    public int evaluate(Supplier<Integer> s) {
        return s.get() + 1;
    }
}