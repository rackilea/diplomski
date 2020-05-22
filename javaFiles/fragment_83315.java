static void findTranslation(Map<String, String> map, String message, String translation) {
    if (message != null && !message.isEmpty()) {
        for (String key : map.keySet()) {
            if (message.startsWith(key)) {
                String currentTranslation = translation + map.get(key);
                String restOfTheMessage = message.substring(key.length());
                if (!restOfTheMessage.isEmpty()) {
                    findTranslation(map, restOfTheMessage, currentTranslation);
                }
                else {
                    System.out.println(currentTranslation);
                }
            }
        }
    }
}