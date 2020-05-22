String error = "";
try (InputStream is = proc.getErrorStream()) {
    error = IOUtils.toString(is, "UTF-8");
}
int exit = proc.waitFor();
if (exit != 0) {
    System.out.println(error);
} else {
    System.out.println("Success!");
}