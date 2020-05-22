public final class FreezingBoilingPoints {

    private int temperature;

    public FreezingBoilingPoints(int temp) {
        temperature = temp;
    }

    public void setTemperature(int temp) {
        temperature = temp;
    }

    public int getTemperature() {
        return temperature;
    }

    private boolean isEthylFreezing() {
        return (temperature <= -173);
    }

    private boolean isEthylBoiling() {
        return  (temperature >= 172);
    }

    private boolean isOxygenFreezing() {
        return (temperature <= -362);
    }

    private boolean isOxygenBoiling() {
        return (temperature >= -306);
    }

    private boolean isWaterFreezing() {
        return (temperature <= 32) ;
    }

    private boolean isWaterBoiling() {
        return (temperature >= 212);
    }

    public String showTempinfo() {
        StringBuilder result = new StringBuilder();

        if (isEthylFreezing()) {
            result.append("Ethyl will freeze");
            result.append("\n");
        }

        if (isEthylBoiling()) {
            result.append("Etheyl will boil");
            result.append("\n");
        }

        if (isOxygenFreezing()) {
            result.append("Oxygen will freeze");
            result.append("\n");
        }

        if (isOxygenBoiling()) {
            result.append("Oxygen will Boil");
            result.append("\n");
        }

        if (isWaterFreezing()) {
            result.append("Water will freeze");
            result.append("\n");
        }

        if (isWaterBoiling()) {
            result.append("Water will boil");
            result.append("\n");
        }

        return result.toString();
    }
}