public TemperatureC(double c)
{

temperature = c;

if (temperature < -273.15)
{
    temperature = -273.15;
}