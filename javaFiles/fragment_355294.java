public class TestMain {

    public static void main(String[] args) {
        Subgroup sg1 = new Subgroup();
        sg1.setFname("Vali");
        sg1.setMname("Sheik");
        sg1.setLname("Sha");
        Group g1 = new Group();
        g1.setSg(sg1);
        try {
            Group g2 = (Group) g1.clone();
            Subgroup sg2 = g2.getSg();
            sg2.setFname("parvez");
            sg2.setMname("syed");
            sg2.setLname("khan");
            g2.setSg(sg2);
            System.out.println(g1);
            System.out.println(g2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}