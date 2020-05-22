public String createRandomCode(int codeLength, String id) {   
    List<Character> temp = id.chars()
            .mapToObj(i -> (char)i)
            .collect(Collectors.toList());
    Collections.shuffle(temp, new SecureRandom());
    return temp.stream()
            .map(Object::toString)
            .limit(codeLength)
            .collect(Collectors.joining());
}