final List<String> strings = new ArrayList<>();
final SecureRandom random = new SecureRandom();
for (int i = 0; i < 600; i++) {
    final String e = new BigInteger(130, random).toString(32);
    strings.add(e);
}

for(String slide : sliding(strings, 100)) {
    System.out.println(slide);
}