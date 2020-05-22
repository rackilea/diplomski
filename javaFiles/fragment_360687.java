import java.util.*;

int Sum = 5000;  //Following the naming convention in Java (and Python) "Sum" should be lowercase

ArrayList<Integer> list = new ArrayList<Integer>();
//Alternatively: List<Integer> list = new ArrayList<Integer>();

list.add(0);
list.add(0);

int x = 1;
while (list.size() < Sum) {
    list.addAll(Collections.nCopies(x, x));
    x += 1;
}