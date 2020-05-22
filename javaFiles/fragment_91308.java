Map<String, String> foods = new HashMap<String, String>();

// here key stores the food codes
// and values are that which will be visible to the user in the drop-down
foods.put("man", "mango");
foods.put("app", "apple");
foods.put("gra", "grapes");

// if this is your servlet or action class having access to HttpRequest object then
httpRequest.setAttribute("foods", foods); // so that you can retrieve in JSP