import java.util.ArrayList;
public class Mode {

public static Pair<T, Integer> mode(T[] a)
 {

    int count = 1, tempCount;
    T popular = a[0];
    T temp;
    for (int i = 0; i < (a.length - 1); i++)
    {
        temp = a[i];
        tempCount = 1;
        for (int j = 1; j < a.length; j++)
        {
          if (temp.equals(a[j]))
            tempCount++;
        }
        if (tempCount > count)
        {
          popular = temp;
          count = tempCount;
        }
      }
      return new Pair(popular, new Integer(count));
        }
    }


public class Pair<X,Y>{
  private X first;
  private Y second;

  public Pair(X x, Y y){
    this.first = x;
    this.second = y;
  }

  public X getFirst(){
    return this.first;
  }
  public Y getSecond(){
    return this.second;
  }

  public boolean equals(Object o){
    if(!(o instanceof Pair)){
      return false;
    }
    Pair p = (Pair) o;
    return
      this.first.equals(p.first) &&
      this.second.equals(p.second);
  }

  public String toString(){
    return String.format("(%s,%s)",first,second);
  }

}