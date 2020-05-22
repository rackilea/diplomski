// command line arguments may be stored in a separate area  
int main(int numOfArgs, char *arguments[])
{ 
    static int i;   
    // stored in BSS 

    int (*fp)(int,char **) = main;  
    // points to code segment 

    static char *str[] = {"thisFileName","arg1", "arg2",0};
    // stored in initialized data segment

    while(*arguments)
        printf("\n %s",*arguments++);

    if(!i++)
        fp(3,str);
}