package com.demo;

final class NotADeque {

    public NotADeque() {}

    public static void main(String[] args) throws ClassNotFoundException, 
        NoSuchMethodException, IllegalAccessException, InvocationTargetException, 
        InstantiationException {
      Class<?> c = Class.forName("com.example.Deque");
      Constructor<?> constructor = c.getDeclaredConstructor();
      constructor.setAccessible(true);//Make the constructor accessible.

      Object o = constructor.newInstance();
      System.out.println(o);
    }
}