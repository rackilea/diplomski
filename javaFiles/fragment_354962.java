while (strLine != null) {
    strLine = br.readLine();
    if (strLine==null)
        break;
    sb.append(strLine);
    sb.append(System.lineSeparator());
    objectArray.add(new Word(strLine));
}