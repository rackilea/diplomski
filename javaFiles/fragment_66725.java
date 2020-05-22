public interface Identifiable {
  public int getId();
}

public <T extends Identifiable> void method(T anIdentifiableObject) {
  anIdentifiableObject.getId();
} 

public void method(Identifiable anIdentifiableObject) {
  anIdentifiableObject.getId();
}