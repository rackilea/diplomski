Scanner scanner = new Scanner(System.in);
List<String> heroNames = new ArrayList<>();

int numHeroes;

System.out.println("How many heroes do you want to play with?");

while (true) {
    try {
        numHeroes = Integer.parseInt(scanner.nextLine());
        break;
    } catch (NumberFormatException e) {
        // continue
    }
}

while (heroNames.size() < numHeroes) {
    System.out.println("Type hero name ("
            + (numHeroes - heroNames.size()) + "/" + numHeroes + " missing):");
    String name = scanner.nextLine();
    if (heroNames.contains(name)) {
        System.out.println(name + " already given. Type a different one:");
    } else if (name != null && !name.isEmpty()) {
        heroNames.add(name);
    }
}

System.out.println("Hero names: " + heroNames);