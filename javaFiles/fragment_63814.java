public static void main(String[] args) {
    boolean[][] possibleStates = {{false,false},{false,true},{true,false},{true,true}};
    int result = count(true,null,possibleStates);
    System.out.println(result);
}
public static int count(Boolean a,Boolean b,boolean[][] possibleStates) {
    int counter = 0;
    Boolean oldA = a;
    Boolean oldB = b;
    for(boolean[] state : possibleStates) {
        a = oldA;
        b = oldB;
        if(a == null) 
            a = state[0];
        if(b == null) 
            b = state[1];
        if(state[0] == a && state[1] == b)
            counter++;
    }
    return counter;
}