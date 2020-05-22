import java.util.*;
import javafx.beans.property.*;

public class Vertex<T>{

  private ObjectProperty<T> element;
  private BooleanProperty visited;

  public Vertex() {
      element = null;
      visited = new SimpleBooleanProperty(false);
  }

  public Vertex(T element) {
      this.element = new SimpleObjectProperty<T>(element);
      this.visited = new SimpleBooleanProperty(false);
  }

  public Vertex(T element, boolean visited) {
      this.element = new SimpleObjectProperty<T>(element);
      this.visited = new SimpleBooleanProperty(visited);
  }

  public void setElement(T elem) {
      this.element.set(elem);
  }

  public T getElement() {
      return this.element.get();
  }

  public ObjectProperty<T> elementProperty(){
      return this.element;
  }

  public void setVisited(boolean b) {
      this.visited.set(b);
  }

  public boolean isVisited() {
      return this.visited.get();
  }

  public BooleanProperty visitedProperty(){
      return this.visited;
  }

  @Override
  public boolean equals(Object o) {
      if(o == this) {
          return true;
      }

      if(!(o instanceof Vertex<?>)) {
          return false;
      }

      Vertex<?> v=  (Vertex<?>) o;

      if(v.getElement() instanceof String) {
          return v.getElement().equals(this.element.get());
      }else {
          return v.getElement() == this.element.get();
      }


  }

  @Override
  public String toString() {
      return element.get().toString();
  }

  public static void main(String[] args) {
    ArrayList<Vertex<String>> listOfNeighbours = new ArrayList<>();
    listOfNeighbours.add(new Vertex<>("foo"));
    listOfNeighbours.add(new Vertex<>("bar"));
    System.out.println(listOfNeighbours);
    listOfNeighbours.sort(Comparator.comparing(Vertex::getElement));
    System.out.println(listOfNeighbours);

    ArrayList<Vertex<Integer>> list2 = new ArrayList<>();
    list2.add(new Vertex<>(1));
    list2.add(new Vertex<>(123));
    list2.add(new Vertex<>(15));
    list2.add(new Vertex<>(2));
    System.out.println(list2);
    list2.sort(Comparator.comparing(Vertex::getElement));
    System.out.println(list2);
    list2.sort(Comparator.comparing(Vertex::getElement, Comparator.comparing(i -> i.toString())));
    System.out.println(list2);
  }
}