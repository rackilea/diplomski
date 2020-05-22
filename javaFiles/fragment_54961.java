User user = User.newBuilder().setUid(1).build();
User user2 = User.newBuilder().setUid(2).build();
try {
    FileOutputStream output = new FileOutputStream(path);
    user.writeDelimitedTo(output);
    user.writeDelimitedTo(output);
    user2.writeDelimitedTo(output);
    output.close();
} catch (Exception e) {
    System.out.print("Write error!");
}

try {
    FileInputStream input = new FileInputStream(path);
    while (true) {
        User user_ = User.parseDelimitedFrom(input);
        if (user_ == null)
            break;
        System.out.println("read from file: \n" + user_);
    }
} catch (Exception e) {
    System.out.println("Read error!");
}