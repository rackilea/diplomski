private void foo(int i){
    byte[] a = new byte[1 * 1024 * 1024];
    System.out.println(i+" "+a.length);
    foo(i+1);
    a[1] += a[0] + 1;
}