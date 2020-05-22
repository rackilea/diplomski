void appendTo (Appendable obj) {
  if (obj instanceof TextMessage) {
    TextMessage msg = (TextMessage) obj;
    msg.setXXX (...);
    ...
  }
}