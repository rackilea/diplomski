public static void main(String[] args) {
    char[] copyFrom={'s','n','a','d','g'};
    char[] copyto=new char[7];
    System.arraycopy(copyFrom, 1, copyto, 0, 3);
    System.out.println(new String (copyto));
    copyto=new char[7];
    System.arraycopy(copyFrom, 1, copyto, 1, 3);
    System.out.println(new String (copyto));
    copyto=new char[7];
    System.arraycopy(copyFrom, 1, copyto, 2, 3);
    System.out.println(new String (copyto));
    copyto=new char[7];
    System.arraycopy(copyFrom, 1, copyto, 4, 3);
    System.out.println(new String (copyto));
}