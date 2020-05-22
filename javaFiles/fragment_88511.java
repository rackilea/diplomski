class CustomClass {
    int[][] arr1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 8, 7 } };

    public static void main(String[] args) {
        CustomClass c = new CustomClass();

        Field[] f = c.getClass().getDeclaredFields();

        for (int i = 0; i < f.length; i++) {
            if (f[i].getName().equals("arr1")) {
                System.out.println(c.arr1[0][0]); // your own logic
            } else if (f[i].getName().equals("arr2")) {
                System.out.println(c.arr2[0][0]); // your own logic
            } else if (f[i].getName().equals("arr3")) {
                System.out.println(c.arr3[0][0]); // your own logic
            } else if (f[i].getName().equals("arr4")) {
                System.out.println(c.arr4[0][0]); // your own logic
            }
        }
    }
}