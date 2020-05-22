final int ARRAY_SIZE = 9;
int data[]={7,7,2,9,9,9,3,3,6};
int val=data[0];
int length=1;
for (int index = 1; index < ARRAY_SIZE; index++){
    if (data[index]==val)
        length++;
    else {
        System.out.println(val+" with length "+ length);
        val=data[index];
        length=1;
    }
}
System.out.println(val+" with length "+ length);