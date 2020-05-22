// recipient is the email address of the... recipient
final ProcessBuilder pb = new ProcessBuilder("mailx", "-r", 
    "sender@foo.com", recipient);

final Path textToSend = Paths.get("Docs/mailtext.txt").toRealPath();
pb.redirectInput(textToSend.toFile());

// Also redirect stdout and stderr somewhere

final Process p = pb.start();

return p.waitFor();