public void SortTicket()
{
    int size = tList.size();
    int end = size-1; // size-1, so you don't get an IndexOutOfBoundsException
    boolean sorted = false;
    for(int i = 0; i < size-1 && !sorted; i++) 
    {
        sorted = true; // if you never execute a swap, the list is already sorted
        for (int j=0; j<end; j++) {
            Ticket t1 = (Ticket) tList.get(j);
            Ticket t2 = (Ticket) tList.get(j+1); // j+1, so you don't change the value of i
            if(t1.GetSurname().compareTo(t2.GetSurname()) > 0)
            { 
                sorted = false;
                tList.remove(j);
                tList.add(j+1, t1); // j+1, so you don't change the value of i
            }
        }
        end--;
    }

    for(int i = 0; i<size; i++)
    {
        Ticket tmpTick = (Ticket) tList.get(i);
        System.out.println(tmpTick.ToString());
    }
}