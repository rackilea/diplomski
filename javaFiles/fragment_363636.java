public interface MileageCalculator
{
    double getMileage(int miles);
    MileageCalculator upgrade();
    MileageCalculator downgrade();
}

public class NormalMileageCalculator implements MileageCalculator
{
    public double getMileage(int miles)
    {
        return miles;
    }

    MileageCalculator upgrade()
    {
        return new SilverMileageCalculator();
    }

    MileageCalculator downgrade()
    {
        return this;
    }
}

public class SilverMileageCalculator implements MileageCalculator
{
    public double getMileage(int miles)
    {
        return miles * 1.5;
    }

    MileageCalculator upgrade()
    {
        return new GoldMileageCalculator();
    }

    MileageCalculator downgrade()
    {
        return new SilverMileageCalculator();
    }
}

// The same for GoldMileageCalculator

class Customer
{
    private MileageCalculator calculator = new NormalMileageCalculator();
    private double mileage;

    public void upgrade()
    {
        calculator = this.calculator.upgrade();
    }

    public void downgrade()
    {
        calculator = this.calculator.downgrade();
    }

    public void update_mileage(int miles)
    {
        this.mileage += calculator.getMileage(miles);
    }
}