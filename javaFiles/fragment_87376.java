public abstract class ReturnTwoTypes<T> {  
    public abstract T runProgram();
}

private class ReturnSetType extends ReturnTwoTypes<Set<String>> {

    @Override
    public Set<String> runProgram(){
        return new TreeSet<String>();
    }
}