Converter<Wrapper, ClassC> converter = wrapper -> {
        //access wrapper
        wrapper.getA();
        wrapper.getB();
        return new ClassC();
};