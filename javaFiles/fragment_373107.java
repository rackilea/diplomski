public interface Operation{
void operate();
} 

public abstract class AbstractClase implements Operation{
 protected Operation delegate;

 public AbstractClase(Operation delegate){
  this.delegate=delegate;
 }

 //delegate implementation responsability to children
 protected abstract doSomething();

}