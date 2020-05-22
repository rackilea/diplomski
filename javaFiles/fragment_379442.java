while(line != null) {
    if (line.length <= MAX_COUNT) { 
        lines.add(line);
    }
    line = reader.readLine();
}
return lines.get(rand.nextInt(lines.size()));