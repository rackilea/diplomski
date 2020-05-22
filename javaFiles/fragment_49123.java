String json = "...";

Map<String, Object> book = JsonPath.read(json, "$.store.book[0]");
System.out.println(book);  // prints {category=reference, author=Nigel Rees, title=Sayings of the Century, price=8.95}

Double price = JsonPath.read(json, "$.store.bicycle.price");
System.out.println(price);  // prints 19.95