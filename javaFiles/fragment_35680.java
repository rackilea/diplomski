while (line != null) {
    String[] att = line.split(",");

    attributes[number] = new double[att.length];
    for (int i = 0; i < att.length; i++)
        attributes[number][i] = Double.parseDouble(att[i]);

    line = reader.readLine();
    number++; // Very important, otherwise you're always updating the same row...
}