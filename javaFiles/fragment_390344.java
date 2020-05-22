public Country(String name, long GDP, int population){
    this.name = name;
    this.GDP = GDP;
    this.population = population;
    GDPCapita = (int) (this.GDP / this.population);
    if(GDPCapita >= 10000){
        classification = "Developed country";
    }else {
        classification = "Developing country";
    }
}