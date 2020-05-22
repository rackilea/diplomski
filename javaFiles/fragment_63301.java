public interface IAnimal
{
    bool IsHealthy { get; }
    void Eat(IAnimal otherAnimal);
}

public class Lion : IAnimal
{
    public Lion()
    {
        this.isHealthy = true;
    }

    public bool IsHealthy
    {
        get { return isHealthy; }
    }

    void Eat(IAnimal otherAnimal)
    {
        if(otherAnimal.IsHealthy && !(otherAnimal is SlimeMold))
        {
            isHealthy = true;
        }
        else
        {
            isHealthy = false;
        }
    }

    private bool isHealthy;
}

IAnimal someAnimal = PullAnAnimalOutOfAWoodenCrate();

Console.WriteLine("The animal is healthy?: " + someAnimal.IsHealthy);