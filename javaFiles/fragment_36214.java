// RUN FUNCTION
Map<String,String> returnMap = myObject.getVideoIdFromUrl("http://www.youtube.com/watch?v=0zM4nApSvMg#t=0m10s");

// PRINT OUTPUT
System.out.println(returnMap);

// PRINTS:
// {id=0zM4nApSvMg, time=0m10s}