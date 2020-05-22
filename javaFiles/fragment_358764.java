public class Partner {

    private String name;
    private Partner partner;

    public Partner(String name) {
        this.name = name;
    }

    public Partner(String name, Partner partner) {
        this.name = name;
        setPartner(partner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartner(Partner partner) {
        partner.partner = this;
        this.partner = partner;
    }

    @Override
    public String toString() {
        String value;
        if (partner != null) {
            value = name + ", partner=" + partner.name;
        } else {
            value = name;
        }
        return value;
    }

    public static void main(String[] args) {
        // Example 1
        Partner p1 = new Partner("Name1");
        Partner p2 = new Partner("Name2");
        p1.setPartner(p2);
        System.out.println(p1);
        System.out.println(p2);

        // Example 2
        Partner p3 = new Partner("Name3");
        Partner p4 = new Partner("Name4", p3);
        System.out.println(p3);
        System.out.println(p4);
    }
}