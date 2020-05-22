private static ReplyKeyboardMarkup getSettingsKeyboard(String language) {
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    replyKeyboardMarkup.setSelective(true);
    replyKeyboardMarkup.setResizeKeyboard(true);
    replyKeyboardMarkup.setOneTimeKeyboad(false);

    List<KeyboardRow> keyboard = new ArrayList<>();
    KeyboardRow keyboardFirstRow = new KeyboardRow();
    keyboardFirstRow.add(getLanguagesCommand(language));
    keyboardFirstRow.add(getUnitsCommand(language));
    KeyboardRow keyboardSecondRow = new KeyboardRow();
    keyboardSecondRow.add(getAlertsCommand(language));
    keyboardSecondRow.add(getBackCommand(language));
    keyboard.add(keyboardFirstRow);
    keyboard.add(keyboardSecondRow);
    replyKeyboardMarkup.setKeyboard(keyboard);

    return replyKeyboardMarkup;
}