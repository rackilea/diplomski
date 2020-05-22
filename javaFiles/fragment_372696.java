String[] picture = { "blue", "white", "red", "yellow" };
//get a list out of your array:
List<String> picturesList = Arrays.asList(picture);
//shuffle the list:
Collections.shuffle(picturesList);
//first picture is the first element in list:
String pictureOne = picturesList.get(0);
System.out.println(pictureOne);
//2nd picture is the 2nd element in list:
String pictureTwo = picturesList.get(1);
System.out.println(pictureTwo);
...