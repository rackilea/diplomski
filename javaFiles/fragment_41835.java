public static void main(String[] args) {
    try {
        //something wrong happens here
    }catch(Throwable e) {
        e.printStackTrace();
        main(args);
    }
}