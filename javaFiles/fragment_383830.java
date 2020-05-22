Building retrieveBuilding(Building[][] buildingMap) {
         System.out.println("Enter X");
         int x = scan.nextInt();
         System.out.println("Enter Y");
         int y = scan.nextInt();
         return buildingMap[x][y];
}

ArrayList<Building> buildings = new ArrayList<Building>();
buildings.add(retrieveBuilding(buildingMap));