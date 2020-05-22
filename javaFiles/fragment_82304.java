public static <E> void genericMethod(E e) {
    final int size = 2;
    Object[] objectArr = new Object[size];
    objectArr[0] = "foobar";

    @SuppressWarnings("unchecked")
    E[] integerArr = (E[]) objectArr;
    integerArr[1] = e;

    System.out.println(Arrays.toString(integerArr));
    System.out.println(e.getClass().getName());
    System.out.println(integerArr.getClass().getName());
}

public static void main(String[] args) {
    genericMethod(new Integer(5)); // E is Integer in this case
}