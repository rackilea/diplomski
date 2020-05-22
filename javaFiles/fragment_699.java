while (prizeIs == chosenDoor)
{
    zonkIs = (int) ((Math.random() * 3) + 1);
    while (zonkIs == prizeIs)
    {
        zonkIs = (int) ((Math.random() * 3) + 1);
    }
}