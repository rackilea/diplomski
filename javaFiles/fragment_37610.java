1.  public Object get(int index) {
2.      if (index < 0 || index > size()) {
3.          System.out.println("get(ObjectLinkedList) index out of bound exception");
4.          return null;
5.      } else if (index == 0) {
6.          return firstNode;
7.      } else {
8.          Node tempNode = firstNode;
9.          for (int i = 0; i <= index; i++) {
10.             if (i == index - 1) {
11.                 tempNode = tempNode.getNext();
12.                 return tempNode;
13.             }
14.         }
15.         System.out.println("objectLinkedList get method nothing found");
16.         return null;
17.      }
18.  }