public static void main(String[] args) {
    System.out.println(byte[].class.getName());
    try {
        Class clazz = Class.forName("[B");
        System.out.println(byte[].class==clazz);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}