else if (!strcmp(*argv,"-hmac"))
{
    if (--argc < 1)
        break;
    hmac_key=*++argv;
}