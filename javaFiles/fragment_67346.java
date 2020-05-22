for (; count > 0; count--, fahrenheit += 5)
{
    // Calculate
    celsius = (fahrenheit - 32)*(5.0 / 9.0);
    System.out.printf("%,.2f \t\t\t %,.2f\n", fahrenheit, celsius);
}