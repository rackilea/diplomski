@Override
public int compare(AllSpeeds lhs, AllSpeeds rhs) {
    // TODO Auto-generated method stub      
    int a = Integer.parseInt(lhs.getSpeed());
    int b = Integer.parseInt(rhs.getSpeed());
    return a < b ? 1 : (a == b ? 0 : -1);
}