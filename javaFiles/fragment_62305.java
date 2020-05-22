String text = "[\"str1\",\"str2\"]"; // represents ["str1","str2"]

Gson gson = new Gson();

String[] array = gson.fromJson(text, String[].class);

System.out.println(array[0]); //str1
System.out.println(array[1]); //str2