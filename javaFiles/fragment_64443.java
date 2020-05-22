File src = new File("user/big folder/data");
File dest = new File("user");

boolean success = src.renameTo(new File(dest, src.getName()));
if (!success) {
    // Directory was not successfully moved
}