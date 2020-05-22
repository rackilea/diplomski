public Shifter(int size){

    for (int i = 0; i < data.length; i++)
    {
        data[i] = i + 1;
    }
}

public void shift(int pos){
    int max = pos % data.length;
    if (max < 0) max += data.length;
    for (int x=0; x<max; x++)
    {
        int cnt = data.length-1;
        int temp = data[cnt];
        for(cnt=data.length-1; cnt>0; cnt--)
        { 
            data[cnt] = data[cnt-1];
        }
        data[0] =temp;
    }
}
public void display(){
    String values = "";
    for (int i = 0; i < data.length; i++)
    {
        values += " ";
        if (data[i] < 10) values += " ";
        values += data[i];
    }
    System.out.printf("Array Contents: %s \n", values);
}