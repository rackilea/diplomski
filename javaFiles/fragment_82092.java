Map<String, String> map = new HashMap<String, String>();
    String test = "pet:cat::car:honda::location:Japan::food:sushi";

    // split on ':' and on '::'
    String[] parts = test.split("::?");

    for (int i = 0; i < parts.length; i += 2) {
        map.put(parts[i], parts[i + 1]);
    }

    for (String s : map.keySet()) {
        System.out.println(s + " is " + map.get(s));
    }