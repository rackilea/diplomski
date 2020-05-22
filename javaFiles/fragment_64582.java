private int randomInteger(int min, int max) 
{
    min = (int) Math.ceil(min);
    max = (int) Math.floor(max);
    return (int) Math.floor(Math.random() * (max - min));
}