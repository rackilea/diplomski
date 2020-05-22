for(Map.Entry<Character, String> entry: cipheredAlphabet.entrySet()) {
    if(entry.getValue().equals(fiveLetters)) {
        ecodedMessage.append(cipheredAlphabet.getKey());
        break;
    }
}