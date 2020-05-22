%module test

%{
#include "test.hh"
%}

%include <carrays.i>
%array_class(signed char, ByteArray);

%pragma(java) modulecode = %{
  // Overload foo to take an array and do a copy for us:
  public static void foo(byte[] array) {
    ByteArray temp = new ByteArray(array.length);
    for (int i = 0; i < array.length; ++i) {
      temp.setitem(i, array[i]);
    }
    foo(temp.cast(), array.length);
    // if foo can modify the input array we'll need to copy back to:
    for (int i = 0; i < array.length; ++i) {
      array[i] = temp.getitem(i);
    }
  }

  // How do we even get a SWIGTYPE_p_signed_char for end for bar?
  public static void bar(byte[] array) {
    ByteArray temp = new ByteArray(array.length);
    for (int i = 0; i < array.length; ++i) {
      temp.setitem(i, array[i]);
    }
    bar(temp.cast(), make_end_ptr(temp.cast(), array.length));
    // if bar can modify the input array we'll need to copy back to:
    for (int i = 0; i < array.length; ++i) {
      array[i] = temp.getitem(i);
    }
  }
%}

// Private helper to make the 'end' pointer that bar expects
%javamethodmodifiers make_end_ptr "private";
%inline {
  signed char *make_end_ptr(signed char *begin, int sz) {
    return begin+sz;
  }
}

%include "test.hh"

%pragma(java) jniclasscode=%{
  static {
    try {
        System.loadLibrary("test");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    }
  }
%}