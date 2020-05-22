package com.stackoverflow.homework;

public class MyApplication
{
  static native boolean setAppUserModelID();

  static
  {
    System.loadLibrary("MyApplicationJNI");
    setAppUserModelID();
  }
}