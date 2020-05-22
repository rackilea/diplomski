int main()
{
    static int i;
    strcpy((char *)main,"something");
    printf("%s",main);
    if(i++==0)
    main();
}