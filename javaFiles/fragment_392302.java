char[] input = ...
char[] result = new char[input.length];
int shift = 2;

for(int i = 0; i < input.length; i++)
{
    result[i] = input[(i + shift) % input.length];
}