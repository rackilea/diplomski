import java.util.Comparator;

public class ClientDayInNumberComparator implements Comparator<Client> {

    @Override
    public int compare(Client c1, Client c2) {
        if(c1.getDayInNumber() > c2.getDayInNumber()) return 1;
        else if(c1.getDayInNumber() < c2.getDayInNumber()) return -1;
        else
            return 0;
    }

}