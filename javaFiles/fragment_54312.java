public class Equipment {
    private String equName;
    private double equGain;
    private double equLoss;
    private double roi;

    public Equipment() {
    }

    public Equipment(String equName, double equGain, double equLoss, double roi) {
        this.equName = equName;
        this.equGain = equGain;
        this.equLoss = equLoss;
        this.roi = roi;

    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public double getEquGain() {
        return equGain;
    }

    public void setEquGain(double equGain) {
        this.equGain = equGain;
    }

    public double getEquLoss() {
        return equLoss;
    }

    public void setEquLoss(double equLoss) {
        this.equLoss = equLoss;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public String toString() {
        return "Equipment: " + equName + " Gain:  " + equGain + "Loss: " + equLoss + "ROI: " + roi;
    }
}