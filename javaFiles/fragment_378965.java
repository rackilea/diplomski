package com.my.test;

import org.junit.Assert;
import org.junit.Test;

public class MyClazzTest {

    @Test
    public void equalObject() {
        MyClazz object = new MyClazz("UK", "Chris", "Window");
        MyClazz duplicateObject = new MyClazz("UK", "Chris", "Window");
        Assert.assertTrue(object.equals(duplicateObject));
    }

    @Test
    public void notEqualObject() {
        MyClazz object = new MyClazz("UK", "Chris", "Window");
        MyClazz differentObject = new MyClazz("US", "Chris", "Window");
        Assert.assertFalse(object.equals(differentObject));
    }
}