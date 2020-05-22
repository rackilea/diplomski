Map< String, List< Member>> membersSplitByState = new HashMap<String, List<Member>>();
    List<Member> tempList = validMembers;

    for (Member member : validMembers) {
        List<Member> membersWithState;
        if (membersSplitByState.containsKey(member.getState()) {
           membersWithState = membersSplitByState.get(member.getState());
        } else {
           membersWithState = new ArrayList<Member>();
           membersSplitByState.put(member.getState(), membersWithState);
        }
        membersWithState.add(member);
    }
    return membersSplitByState;