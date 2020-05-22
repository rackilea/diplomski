Mp3File mp3file = new Mp3File("SomeMp3File.mp3");
System.out.println("Length of this mp3 in seconds is: " + mp3file.getLengthInSeconds());
if(mp3file.hasId3v2Tag()) {
   ID3v2 id3v2tag = mp3file.getId3v2Tag();
   System.out.println("The artist in the ID3v2 tag is: " + id3v2tag.getArtist());

   id3v2tag.setArtist("A new artist");
   mp3file.save("ASavedMp3File.mp3");
   System.out("Saved mp3 file with new name and artist set to 'A new artist'");
}