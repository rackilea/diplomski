public static void main(String[] args) {
    String username ="";
    String password = "";
    Class_b b = new Class_b();
    String[] arr = b.login(username,password);
    if (arr.length > 1) {
        username = arr[0];
        password = arr[1];
    }
    System.out.println("username=" + username + ", password=" + password);
}