public class Worker2{
    ArrayList<String> list = new ArrayList<>();

    // this is now executed on the FX Application Thread: there is no need 
    // for Platform.runLater():

    public int doSomething(int index, TextArea area){
            area.append(list.get(index)); 
    }
}