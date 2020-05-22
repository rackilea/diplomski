int i = 1;
 for (int count = 2; count <= limit; count++) { 
    if (!match[count]) {
        if (i%10 == 0) 
            System.out.print(count+ "\n");
        else 
            System.out.print(count + ", ");
        i++;
    } 
}