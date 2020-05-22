// private to force clients to use the static factory method
private MessageSelect() {
  initComponents();
  messagesJList.setPrototypeCellValue("xxx");
}

public static MessageSelect createInstance() {
  MessageSelect instance = new MessageSelect();
  instance.controller.addObserver(instance);
  return instance;
}