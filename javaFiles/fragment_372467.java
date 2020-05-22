// parse html
Jerry doc = jerry("<li class=\"item list1\"><a class=\"link\"></li>");

// get element by class name
Jerry li = doc.$(".item");
// or
Jerry li = doc.$(".list1");