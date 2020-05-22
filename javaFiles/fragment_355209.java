public static String santizeFilename(String original){
    Pattern p = Pattern.compile("(.*)-(.*)\\.mp3");
    Matcher m = p.matcher(original);

    if (m.matches()){
        String artist = m.group(1).replaceAll("[^a-zA-Z ]", "");
        String song = m.group(2).replaceAll("[^a-zA-Z ]", "");

        return String.format("%s - %s", artist, song);
    }
    else {
        throw new IllegalArgumentException("Failed to match filename : "+original);
    }

}