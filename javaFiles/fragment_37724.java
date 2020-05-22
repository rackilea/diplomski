trackCount = sc.nextInt();
sc.nextLine(); // collect endline character
sc.useDelimiter(", ");
albumName = f.toString();
while (sc.hasNextLine()) {
    trackNumber = sc.nextInt();
    songName = sc.next();
    artistName = sc.next();
    sc.nextLine(); // collect endline character

    processLine(albumName, artistName, songName, trackNumber);
}
sc.close();