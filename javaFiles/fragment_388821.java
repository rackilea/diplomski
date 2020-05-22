public class NumberIndex extends ArrayList<Integer> {

    public NumberIndex() {
        super(10);//setting the size of your NumberIndex object -> list size
    }

    public NumberIndex(int x) {
        super(x);//setting the size of your NumberIndex object -> list size
    }

    public void addWord(int num) {
        if(!this.contains(num)){//if the current NumberIndex object (list) does not contain num
            this.add(num);//to the current NumberIndex object (list) add num
        }
    }

}