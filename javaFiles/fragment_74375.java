@Entity
public class Animal implements FieldHandled {
 private Person owner;
 private FieldHandler fieldHandler;

 @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "animal")
 @LazyToOne(LazyToOneOption.NO_PROXY)
 public Person getOwner() {
  if (fieldHandler != null) {
   return (Person) fieldHandler.readObject(this, "owner", owner);
  }
  return owner;
 }

 public void setOwner(Person owner) {
  if (fieldHandler != null) {
   this.owner = fieldHandler.writeObject(this, "owner", this.owner, owner);
   return;
  }
  this.owner = owner;
 }

 public FieldHandler getFieldHandler() {
  return fieldHandler;
 }

 public void setFieldHandler(FieldHandler fieldHandler) {
  this.fieldHandler = fieldHandler;
 }
}