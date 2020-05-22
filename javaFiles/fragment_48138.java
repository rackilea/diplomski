obj.addProperty("Id", "001");

System.out.println("Before: " + obj.get("Id")); // 001

obj.addProperty("Id", "002");

System.out.println("After: " + obj.get("Id")); // 002