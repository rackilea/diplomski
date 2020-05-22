public List<Message> getMessages(String fileName) throws IOException {
    List<Message> messages = new ArrayList<>();
    try {
        String from;
        String to;
        String body;
        Message message;
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (int i = 0; i < lines.size(); i += 3) {
            from = lines.get(i);
            to = lines.get(i + 1);
            body = lines.get(i + 2);
            message = new Message(from, to, body);
            messages.add(message);
        }
    } catch (IOException e) {
        throw e;
    }
    return messages;
}