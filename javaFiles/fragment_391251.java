int arr [] = new int [4];

 // check input is 4 in length then

for (int i = 0; i < input.length(); i++)
{
    char x = input.charAt(i);
    int y = Character.getNumericValue(x);
    int seven = addSeven(y);
    int mod = modulusTen(seven);
    arr[i] = mod;
}

// then perform your swap logic

int tmp = arr [0];
arr[0] = arr[2];
arr [2] = tmp;

tmp = arr[1];
arr[1] = arr[3];
arr[3] = tmp;