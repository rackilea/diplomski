SendMessage message = new SendMessage();
    message.enableMarkdown(true);
    message.setReplyMarkup(getSettingsKeyboard(language));
    message.setReplyToMessageId(message.getMessageId());
    message.setChatId(message.getChatId().toString());
    message.setText(getSettingsMessage(language));