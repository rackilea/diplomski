public static void main(String[] args) {
    File.tap((f) -> {
        File.mkdir("dir");
        File.mkdir("dir2");
    });
}