StringBuilder sb = new StringBuilder();
while (sc.hasNextLine()) {
    sb.setLength(0); // clear the stringbuilder

    String line = sc.nextLine(); 
    if (line.isEmpty()) continue; // if you want to skip blank lines
    else sb.append(line).append("\n");

    for (int i = 1; i < 3 && sc.hasNextLine(); i++) {
        line = sc.nextLine(); 
        sb.append(line).append("\n");
    }
    String[] lines = sb.toString().trim().split("\n");
    if (lines.length == 3) {
        String prev2 = lines[0];
        String prev1 = lines[1];
        String curr = lines[2];

        doStringThings(prev2, prev1, curr);
    }
}