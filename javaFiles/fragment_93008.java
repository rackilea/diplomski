public void addMessages(List<Object> messages) {
    if (!CollectionUtils.isEmpty(messages)) {
        for (Object message : messages) {
            this.messages.add(String.valueOf(message));
        }
    }
}