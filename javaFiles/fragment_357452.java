long l;
try {
    l = Long.parseLong(currSong.getDuration());
} catch(NumberFormatException e){
    e.printStackTrace();
}