if (nameFromFile.equalsIgnoreCase(result)) {
    if (!output.toString().contains(ags[j] + ":"))
        output.append(ags[j] + ":");
    output.append(" " + nameFile + ", ");

}