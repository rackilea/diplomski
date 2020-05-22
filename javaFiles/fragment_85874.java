public synchronized void putData(String s){
    while(this.isFull()){
        try{
            wait();
        }catch(InterruptedException e){
            //
            e.printStackTrace();
        }
    }
    data.add(s);
    notifyAll();
}

public synchronized String getData(){
    while(this.isEmpty()){
        try{
            wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    String s_data = (String)(data.get(0));
    if(s_data != null){
        data.remove(s_data);
        System.out.println(s_data);
    }
    notifyAll();
    return s_data;
}