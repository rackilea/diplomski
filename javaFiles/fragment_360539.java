int counter=123; // replaced IO code so I did not have to download the jar.
int older=1;
int old =1;
int current=2;

System.out.println(older);  // prints the first 1
System.out.println(old);  // prints the second 1
System.out.println(current);  // prints the 2

while(current<counter){
    int nextnumber=older+old+current;
    older=old;
    old=current;
    current=nextnumber;
    if(nextnumber <= counter)       
    {
        System.out.println(nextnumber);
    }
}