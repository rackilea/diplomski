package com.example;

public class ClassWithPrivate {
    private String s = "myStr";
}

==========

package com.example.aspect;

import com.example.ClassWithPrivate;

privileged public aspect AccessPrivate {

    public String ClassWithPrivate.getS() {
        return this.s;
    }

    public void ClassWithPrivate.setS(String str) {
        this.s = str;
    }
}

==========

package com.example;

public class TestPrivate {

    public static void main(String[] args) {

        ClassWithPrivate test = new ClassWithPrivate();
        System.out.println(test.getS());
        test.setS("hello");
        System.out.println(test.getS());
    }
}