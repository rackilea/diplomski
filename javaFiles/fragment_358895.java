public class TwoDimensitnArraySort {
public static void main(String[] args) {
    int ary[][] = {{8, 9},{4, 6},{5, 11},{3, 4},{4, 7},{2, 6}};

    ArrayList<TwoDArray> list = new ArrayList<TwoDArray>();

    for(int i = 0;i<ary.length;i++){
        int k = ary[i][0];
        int v = ary[i][1];
        list.add(new TwoDArray(k, v));
    }

    Collections.sort(list);
    int index = 0;
    for(TwoDArray element : list){
        for(int i = 0;i<ary.length;i++){
            if(element.getKey() == ary[i][0] && element.getValue() == ary[i][1]){
                System.out.print(i + " ");
            }
        }
    }
}
}

class TwoDArray implements Comparable<TwoDArray>{
    int key;
    int value;

    public TwoDArray(int key,int value) {
        this.key = key;
        this.value = value;
    }


    public int getKey() {
        return key;
    }



    public void setKey(int key) {
        this.key = key;
    }



    public int getValue() {
        return value;
    }



    public void setValue(int value) {
        this.value = value;
    }



    public int compareTo(TwoDArray o) {
        if(o.getValue() >= this.getValue()){
            return -1;
        }else if (o.getValue() < this.getValue()){
            return 1;
        }
        if(o.getValue() == this.getValue()){
            if(o.getKey() >= this.getKey()){
                return -1;
            }else if (o.getKey() < this.getKey()){
                return 1;
            }
        }

        return 0;
    };
    @Override
    public String toString() {
        return this.key + ":" + this.value;
    }
}