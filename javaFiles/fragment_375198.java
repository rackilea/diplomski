public class Membership {
    private final Map<Integer, Member> members = new HashMap<>();

    public void addMember (Integer uniqueId, Member member) {
        members.put (uniqueId, member);
    }

    public void getMember (Integer uniqueId) {
        return members.get (uniqueId);
    }

    ...
}