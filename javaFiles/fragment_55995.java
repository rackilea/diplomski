public class Repository {
    private Map<Apartment, List<Expense>> dic = new HashMap<Apartment, List<Expense>>();

    public void addKeyWithList(Apartment apt, ArrayList<Expense> exp){
        dic.put(apt, exp);
    }

    public boolean isEmpty() {
        return dic.isEmpty();
    }
}