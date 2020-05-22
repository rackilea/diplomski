public static String toUserFriendlyErrorMessage(String message) {
    for (String key : replacements.keySet()) {
        message = message.replaceAll(key, replacements.get(key));
    }
    return message;
}