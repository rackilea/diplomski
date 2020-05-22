public static enum ECondition {
    EQ,NE,LT,GT,LE,GE
}
public static enum EVariables {
    MY_ARRAY, MY_OTHER_VAR
}

public void eval(ECondition myCondition, EVariables myVar, String myIndex) {
    ...

    if(myVar.equals(EVariables.MY_ARRAY)) {
        doSometingToMyArrayAtIndex(myCondition,Integer.parseInt(myIndex), Object /* whatever type it is*/ myReferenceValue);
    } else if(myVar.equals(EVariables.MY_OTHER_VAR)) {
        doSometingToMyOtherVar(myCondition);
    }
}

public void doSometingToMyArrayAtIndex(ECondition cond, Integer index, Object myReferenceValue) {
    boolean isConditionTrue = false;
    switch(cond) {
        case EQ:
            isConditionTrue = (myArray[index] == myReferenceValue);
            break;
        case NE:
            isConditionTrue = (myArray[index] != myReferenceValue);
            break;
      // ... and so on
    }
}