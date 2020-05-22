while ( entry != pin && tries < MAX_TRIES ) //tries < 3
{
    System.out.println("\nINCORRECT PIN. TRY AGAIN.");
    System.out.print("ENTER YOUR PIN: ");
    entry = keyboard.nextInt();
    tries++;
}