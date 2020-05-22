Scanner scan = null;

try {
    scan = new Scanner(file);
    String token = scan.next();
    // do something with token
} catch (Exception ex) {
    // print out error message
} finally
    scan.close();
}