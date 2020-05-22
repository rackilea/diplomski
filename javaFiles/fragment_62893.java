String str1 = "<img alt=\"Рейтинг \" src=\"https://itvdn.blob.core.windows.net/images/images-bfa852f3-c227-46dd-86d7-2628f7338b0b.png\">";
String str2 = "<img class=\"w640\" id=\"customHeaderImage\" src=\"http://i067.radikal.ru/1412/23/c71d6e8e7d47.jpg\">";
//                                  | preceded by "img"
//                                  |       | any character, reluctantly quantified
//                                  |       |   | followed by "src"
//                                  |       |   |        | replace with 1 space
System.out.println(str1.replaceAll("(?<=img).+?(?=src)", " "));
System.out.println(str2.replaceAll("(?<=img).+?(?=src)", " "));