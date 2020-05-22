import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Test1 {
    enum MembershipStat {CoPresident, Secretary, Treasurer, RegMember,Sponser}
    public static void main (String[] args)
    {

        final int CoPresidents = 2;



        Map<String, MembershipStat> roster = new HashMap<String, MembershipStat>();
        roster.put("ChaseW", MembershipStat.CoPresident);
        roster.put("Saif", MembershipStat.CoPresident);
        roster.put("MrLee", MembershipStat.Sponser);
        roster.put("Rahil", MembershipStat.Secretary);
        roster.put("Donovon", MembershipStat.RegMember);
        roster.put("Armaan", MembershipStat.RegMember);
        roster.put("Elliot", MembershipStat.RegMember);
        roster.put("JacksonM", MembershipStat.Treasurer);
        roster.put("Cyrus", MembershipStat.RegMember);
        roster.put("Avery", MembershipStat.RegMember);
        roster.put("PeterM", MembershipStat.RegMember);
        roster.put("Mahdi", MembershipStat.RegMember);
        roster.put("GeorgeW", MembershipStat.RegMember);

        System.out.println(checkFor(roster, MembershipStat.RegMember));


    }
    public static int checkFor(Map<String, MembershipStat> roster, MembershipStat check){
        int x = 0;
        Iterator<MembershipStat> it = roster.values().iterator();
        while(it.hasNext()){
            MembershipStat y = it.next();
            System.out.println(y);
            if(y.equals(check))
                x++;
        }
        return x;
    }
}