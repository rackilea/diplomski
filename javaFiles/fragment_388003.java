public int checkFor(MembershipStat[] ms, MembershipStat check){
    int x = 0;
    for(MembershipStat m : ms){
        if(m.equals(check))x++;
    }
    return x;
}