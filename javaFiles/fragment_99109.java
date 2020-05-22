String[] values = ...
int[] numbers = new int[values.length];

for (int i = 0; i < values.length; i++)
{
    numbers[i] = Integer.parseInt( values[i] );
}