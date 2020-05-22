String line = sc.nextLine();
String[] parts = line.trim().split(",");
String title = parts[0];
String artist = parts[1];
CD cd = new CD(title, artist);
discsArray.add(cd);