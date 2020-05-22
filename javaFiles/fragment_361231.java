double percentage = 50.0;
int max = (int)percentage * token.length;

int[] skip = new int[token.length];
int count = 0;
while(count < max)
{
    int rand = rnd.nextInt(token.length);
    if(skip[rand] == 0){
        skip[rand] = 1;
        count++;
    }
}

//Use a for loop to print token where the index of skip is 0, and skip index of those with 1.