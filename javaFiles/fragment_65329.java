package com.example.native;
public class NativeHelper {
     public native String getNewString();
     static
     {
         System.loadLibrary("nativeTest");
     }
}