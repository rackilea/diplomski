Random random = new Random();
    Set<String> usedNames = new HashSet<String>(20);

    while (usedNames.size() < 20) {
        int rowNum = random.nextInt(lines.size());
        String name = lines.get(rowNum);
        if (!containsNameWithSameFirstCharacter(usedNames, name)) {
            usedNames.add(name);
            writer.write(name);
            writer.newLine();
        }
    }