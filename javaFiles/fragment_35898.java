public class Country {

String name;int population; String capital,language,currentcy;
int image;

public Country(String name, int population, String capital, String language, String currentcy, int image) {
    this.name = name;
    this.population = population;
    this.capital = capital;
    this.language = language;
    this.currentcy = currentcy;
    this.image = image;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getPopulation() {
    return population;
}

public void setPopulation(int population) {
    this.population = population;
}

public String getCapital() {
    return capital;
}

public void setCapital(String capital) {
    this.capital = capital;
}

public String getLanguage() {
    return language;
}

public void setLanguage(String language) {
    this.language = language;
}

public String getCurrentcy() {
    return currentcy;
}

public void setCurrentcy(String currentcy) {
    this.currentcy = currentcy;
}

public int getImage() {
    return image;
}

public void setImage(int image) {
    this.image = image;
}
}