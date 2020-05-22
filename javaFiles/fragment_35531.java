StringBuilder sb = new StringBuilder();
for (String line : Files.readAllLines(file.toPath())) // The function Files.readAllLines reads the file using standard UTF-8 encoding
{
  sb.append(line).append('\n');
}
return sb.toString();