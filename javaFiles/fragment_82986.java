for (int i = 0; i < fileNames.length; i++)
{
    fileNames[i] = fileNames[i].replace(".jpg", ""); //Removes .jpg from the file names
}
ZeroNum[] numbers = new ZeroNum[];
for (int i = 0; i < numbers.length; i++)
{
    numbers[i].zeros = fileNames[i].length() - Integer.toString(Integer.parseInt(fileNames[i])).length(); // total length of string minus non-zero
    numbers[i].num = Integer.parseInt(fileNames[i]);
}

class ZeroNum
{
    int num, zeros;
    public ZeroNum(int num, int zeros)
    {
        this.num = num;
        this.zeros = zeros;
    }
}