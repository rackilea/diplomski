@Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Values for this song:");
    sb.append("\n\tArtist: " + artistName);
    sb.append("\n\tTitle: " + songName);
    sb.append("\n\tRelease Date: " + releaseDate);
    sb.append("\n\tTrack Number: " + trackNumber);
    sb.append("\n\tComposer: " + composer);
    sb.append("\n\tPublisher: " + publisher);
    sb.append("\n\tLength: " + length);
    sb.append("\n");
    System.out.println(sb.toString());
    return null;
}