final int DEPTH = 32 //2^n where n is the depth of the quartile tree

for(int j = 1; j < DEPTH; j *= 2){
    double quotient = 1.0 / j;   //How many quartiles to generate

    for(int i = 1; i < j; ++i)
        if(i % 2 != 0)
            System.out.println((i * quotient));
    System.out.println("-------");
}