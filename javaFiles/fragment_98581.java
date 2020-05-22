package com.foo;

import java.util.Arrays;

public class TestVarArgs {

    public void test(String...strings){

    }
    public static void main(String[] args) {
        new TestVarArgs().test(Arrays.copyOfRange(args, 1, 11));
    }
}