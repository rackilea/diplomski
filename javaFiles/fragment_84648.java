Map<String, CreatureFactory> creatureMap = new HashMap<String, CreatureFactory>();
creatureMap.put("H", new HumansFactory());
creatureMap.put("E", new ElfsFactory());
creatureMap.put("D", new DwarfsFactory());
creatureMap.put("O", new OrcsFactory());
creatureMap.put("W", new WargsFactory());

// inside the loop
CreatureFactory factory = creatureMap.get(option);
if ( null == factory ) {
    if ( "F".equals(option) {
            System.out.println("Your army has been created");
            showPrincipalMenu();                    
            return description;
        } else {
            System.out.println("Mistmatch");
            break;
        } 
    ArrayList<Integer> warriors = description.get(factory);
    if ( null == warriors ) {
        // not added before
        warriors = new ArrayList<Integer>();
        description.put(factory, warriors);
    }
    warriors.addAll(getTroopNumberOfWarriors(buffer));
}