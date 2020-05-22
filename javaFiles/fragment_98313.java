private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

public LocalDateTime getTimeFromLine(String line) {
  String clockString = line.split("\t")[2];
  return LocalDateTime.parse(clockString, fmt);
}