public int doLotsOfStuff(String arg0, int arg1, boolean arg2, BiFunction<Boolean, String, Integer> arg3){
    arg0 = reverse(arg0);
    foo(arg1, arg2);
    return bar(arg0, Integer.valueOf(arg1), arg2, arg3);
}

String reverse(String arg0){
    StringBuilder foobar = new StringBuilder(arg0);
    foobar.reverse();
    return foobar.toString();
}

void foo(int arg0, boolean arg1){
    System.out.println(arg1 ? ~arg0 : arg0);
}

<A, B> int bar(String arg0, A arg1, B arg2, BiFunction<B, String, A> arg3){
    return String.valueOf(arg3.apply(arg2, arg1)).concat(arg0).hashCode();
}