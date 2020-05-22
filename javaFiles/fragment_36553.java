Map<String, String> binding = new HashMap<>();
binding.put("TO", "rcpt");
binding.put("MESSAGE_ID", "37");
binding.put("ID", "40");
binding.put("UNIQID", "cff47534-fe6b-c45a-7058-8301adf1b97");
binding.put("XO", "abcdef");
binding.put("XOR", "abcdef");

String text  = s;
groovy.text.SimpleTemplateEngine engine = new groovy.text.SimpleTemplateEngine();
Template template = engine.createTemplate(text);
    for (int i = 0; i < 50000; i++) {
        template.make(binding).toString();
    }

    long timeTaken = System.currentTimeMillis() - start;
    System.out.println("Time taken in ms = "+ timeTaken);
}