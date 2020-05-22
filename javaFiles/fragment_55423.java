public interface Ingredient<T> {
     public List<T> getAll();
     public T get(String id);
     public int size();
     public void add(T item);
     public void remove(T item);
}

public interface Gravy {
     public Ingredient<Giblet> getGiblets();
     public Ingredient<Carrot> getCarrots();
     public Ingredient<Gravy> getGravies();
}