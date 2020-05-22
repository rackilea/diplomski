public class ChatEntry implements Comparable<ChatEntry>{
    String message;
    String user;
    Date date;

    @Override
    public int compareTo(ChatEntry other) {
      return date.compareTo(other.date);
    }
  }