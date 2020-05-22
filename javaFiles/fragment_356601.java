String line = readIn.readLine(); // Presuming that readIn is a BufferedReader
Matcher m = RECORDING_HEADER.matcher(line);

if (m.matches()) {
  final int artistGroup = 2;
  String artist = m.group(artistGroup);

  final int titleGroup = 4;
  String title = m.group(titleGroup);

  final int lyricsGroup = 6;
  String lyrics = m.group(lyricsGroup);

  if (artist != null) {
    // You've got an artist...
  } else if (title != null) {
    // etc...
  }
}