String text = "There is a user <username> who has a password <password>";
Map<String, String> tokens = new HashMap<>();
tokens.put("<username>", "myUser");
tokens.put("<password>", "myPass");

for (Map.Entry<String, String> entry : tokens.entrySet()) {
    text = text.replaceAll(entry.getKey(), entry.getValue());
}

System.out.println(text);

There is a user myUser who has a password myPass