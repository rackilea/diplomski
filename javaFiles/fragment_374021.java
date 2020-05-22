public void setTerrain(int terrain){
    if (terrain < 0 || terrain > 2) {
        System.out.println("Invalid terrain number!");
    } else {
        this.terrain = terrain;
    }
}