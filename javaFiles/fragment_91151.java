String mainStr = "The city of San Francisco is truly beautiful!";
String catchStr = "San Francisco";
String mainStrArr[] = mainStr.split(" ");
String catchStrArr[] = catchStr.split(" ");

String finalArr[] = find(mainStrArr, catchStrArr, catchStr);