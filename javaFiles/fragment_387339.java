package forum7014746;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Food {

    private String food;
    private String beverage;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

}