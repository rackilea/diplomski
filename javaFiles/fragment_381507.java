String playerInvTemp[] = thePlayer.getPlayerInv();
for (int i=0; i < playerInvTemp.length; i++)
{
    if (!playerInvTemp[i].isEmpty()) || playerInvTemp[i] == null)
    {
        setPlayerInv("Blood Essence", i);
        //invText.setText();
        Blood = true;
        break;
    }
}