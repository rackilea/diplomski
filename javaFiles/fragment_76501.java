public class CreditCard {

    private String event;
    private String name;

    public CreditCard() {
        // TODO Auto-generated constructor stub
    }

    public CreditCard(String event, String name) {
        super();
        this.event = event;
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreditCard [event=" + event + ", name=" + name + "]";
    }

    public static void main(String[] args) {
        List<CreditCard> list = new ArrayList<CreditCard>();
        list.add(new CreditCard("A", "John1"));
        list.add(new CreditCard("B", "John2"));
        list.add(new CreditCard("C", "John3"));

        list.add(new CreditCard("A", "mark1"));
        list.add(new CreditCard("B", "mark2"));
        list.add(new CreditCard("C", "mark3"));

        Map<String,List<CreditCard>> obj = list.stream().collect(Collectors.groupingBy(CreditCard::getEvent,Collectors.toList()));
    }
}