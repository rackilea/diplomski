String gotString  = "C:\\Users\\Peado Inffitech 5\\Desktop\\eclipse\\jsp\\UsersPanel\\upload\\uploadsPenguins.jpg";


String newString = gotString.replace("C:\\Users\\Peado Inffitech 5\\Desktop\\eclipse", "").replace("\\", "/");

System.out.print(newString);