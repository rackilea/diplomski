for(int index = 0; index < list.size(); index++) {
    String line = list.get(index);
    if (line != null && line.charAt(0) == ',') {
        line = line.replaceFirst("^,+");
        list.set(index, line); // Replace the string in the list
    }
}