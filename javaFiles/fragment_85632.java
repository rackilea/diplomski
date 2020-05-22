try {
    read = new Scanner(file);
    do {
        String line = read.nextLine();
        String[] parts = line.split(",\\s*");
        int id = Integer.parseInt(parts[0]);
        String date = parts[1];
        String name = parts[2];
        String location = parts[3];
        String reporter = parts[4];
        attack = new MonsterAttack(id, date, name, location, reporter);
        monsterAttacks.add(attack);
    } while (read.hasNext());

    read.close();
} catch(IOException e){
    e.printStackTrace();
}