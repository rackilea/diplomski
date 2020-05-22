System.out.println("please choose the number you would want to add more information to");
int in = input.nextInt();

int index;
for (int i = 0; i < A1.length; i++){
    if (A1[i] == in)
        index = i;
}

System.out.println("Enter the new entry:");
A2[index] = input.next();