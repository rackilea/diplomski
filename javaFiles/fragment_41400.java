try {
    while ((charbyte = stream.read()) != 0){
        strbuilder.append(Character.toChars(charbyte));
    }
    return strbuilder.toString();
}