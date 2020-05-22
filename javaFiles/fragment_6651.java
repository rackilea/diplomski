public class ParentEntity {

  // add child to the parent entity, maintains association
  public void addChild(ChildEntity child) {
    if ( child.getParent() != null ) { 
      child.getParent().removeChild( child );
    }
    child.setParent( this );
    children.add( child );
  }

  // remove child from parent, disassociates association
  public void removeChild(ChildEntity child) {
    if ( this.equals( child.getParent() ) ) {
      child.setParent( null );
      children.remove( child );
    }
  }
}