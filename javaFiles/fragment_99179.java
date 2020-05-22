public class MethodExecutor {
    List<Runnable> listOfMethodsToExecute = new ArrayList<>();

    //Add a new function to the list
    public void addFunction(Runnable f){
       if(f!=null){
            listOfMethodsToExecute.add(f);
       }
    }

    //Executes all the methods previously stored on the list
    public void executeAll(){
        listOfMethodsToExecute.forEach(Runnable::run);
    }
}