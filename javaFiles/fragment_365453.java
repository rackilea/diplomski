int i = 0;
while ((line = responseStreamReader.readLine()) != null) {
    if(i != 0)
        stringBuilder.append("\n");

    stringBuilder.append(line);

    i++;
}