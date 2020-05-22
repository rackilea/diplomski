import java.io.IOException;

public class ArrayLL {

    public static void main(String[] args) throws IOException {
        ArrayLL myList  = new ArrayLL();
        myList.addElem("c");
        myList.addElem("b");
        myList.addElem("a");
        myList.addElem("d");
        int i = myList.startOfListIndex;
        while(myList.list[i].getLink()!=-1)
        {
            System.out.println(myList.list[i].getData());
            i = myList.list[i].getLink();
        }
        System.out.println(myList.list[i].getData());
    }

    private int MAX_CAP = 100;
    private ANode[] list;
    private int size;
    private int startOfListIndex = 0;

    public ArrayLL() {
        list = new ANode[MAX_CAP];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ANode(null);
        }
        size = 0;
    }

    public void addElem(String s) throws IOException {
        if (this.getSize() == 0) {
            ANode a = new ANode(s, -1);
            list[0] = a;
        } else if (size == MAX_CAP + 1) {
            throw new IOException("List is full");
        } else {
            int index = 0;
            for (int i = 0; i < list.length; i++) {
                if (list[i].getData() == null) {
                    index = i;
                    break;
                }
            }
            ANode b = new ANode(s);
            list[index] = b;
            if (this.getSize() == 1) {
                if (list[index].getData().compareTo(list[0].getData()) < 0) {
                    list[index].setLink(0);
                    list[0].setLink(-1);
                    startOfListIndex = index;
                } else {
                    list[index].setLink(-1);
                    list[0].setLink(index);
                }
            } else {
                int i = startOfListIndex;
                int prevIndex = -1;
                while (i!=-1 && list[i].getData() != null) {
                    if (list[index].getData().compareTo(list[i].getData()) < 0) {
                        list[index].setLink(i);
                        if(prevIndex!=-1)
                            list[prevIndex].setLink(index);
                        else
                            startOfListIndex = index;
                        break;
                    } else {
                        prevIndex = i;
                        i=list[i].getLink();
                    }
                }
                if(i==-1)
                {
                    list[prevIndex].setLink(index);
                }
            }
        }
        size++;
    }

    public ANode[] getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

}

class ANode {
    private String data;
    private int link;

    public ANode(String d) {
        data = d;
        link = -1;
    }

    public ANode(String d, int l) {
        data = d;
        link = l;
    }

    public String getData() {
        return data;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int l) {
        link = l;
    }
}