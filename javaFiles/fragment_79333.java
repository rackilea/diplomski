int x = 0;
int y = 0;
Random r = new Random();

while(x < array.length){

    y = x + r.nextInt(array.length-x);
    System.out.println(array[y]);

    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;

    x++;
}