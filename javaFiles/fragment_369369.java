switch (shipSelector) {
            case 1:
                Frigate ship1 = new Frigate();
                System.out.println("Give your ship a name!");
                String shipNamer = keyboard.nextLine();
                ship1.setupShip("Frigate", shipNamer);
                break;
            case 2:
                Shuttle ship2 = new Shuttle();
                System.out.println("Give your ship a name!");
                String shipNamer = keyboard.nextLine();
                ship2.setupShip("Frigate", shipNamer);
                break;
            case 3:
                Cruiser ship3 = new Cruiser();
                System.out.println("Give your ship a name!");
                String shipNamer = keyboard.nextLine();
                ship3.setupShip("Frigate", shipNamer);
                break;
            default:
                break;
        }