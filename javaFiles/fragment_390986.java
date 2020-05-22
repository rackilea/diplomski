Message MainMessage = null;

String json = "";

boolean firstWrite = false;

final Pattern pattern = Pattern.compile("[a-zA-Z0-9]+", Pattern.MULTILINE);

for (int x = 0; x < size; x++) {
    result = "";
    progressBar.setValue(x);

    String line = parsed.get(x);

    if (config.debug) {
        System.out.println(line);
    }

    Message message = new Message(line);
    final Matcher matcher = pattern.matcher(message.plainMessage);

    if (!matcher.find()) {
        continue;
    }

    if (x == 0 && mainSender == null) {
        mainSender = message.sender;
        MainMessage = message;
        continue;
    }

    if (mainSender.equals(message.sender)) {
        MainMessage = message;
    } else if (message.sender != mainSender && MainMessage != null) {
        json = "\n{\"sender\": \"" + MainMessage.sender + "\", \"message\": \"" + MainMessage.message + "\", \"response\": ";
        json += "{\"sender\": \"" + message.sender + "\", \"message\": \"" + message.message + "\"}}";
        if (firstWrite) {
            json = "," + json;
        }

        Files.write(Paths.get(
            export), json.getBytes(), StandardOpenOption.APPEND);
        json = "";
        MainMessage = null;

        firstWrite = true;
    }
}