new Model<Message>() {
  @Override
  public Message getObject() {
    return MessagePanel.this.getModelObject().getMessage(); //or something similar
  }
}