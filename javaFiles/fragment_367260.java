public static void main(String[] args) {            
    GetData getData = new GetData(new MyMainClass());
    getData.start();        
}

public void useText(String text) {
    System.out.println(text);
    // do something...          
}