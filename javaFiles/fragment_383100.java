public int foo(int i) { 
    if (i > 0) { 
        int recurse = foo(i - 1);
        System.out.println("i: " + i + "; foo(i - 1): " + recurse);
    } 
    return i; 
}