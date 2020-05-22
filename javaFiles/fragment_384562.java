import org.eclipse.persistence.indirection.IndirectContainer;

// entities must already be detached here, otherwise SQL UPDATEs will be triggered!
Employee e = phone.getEmployee();
IndirectContainer container = (IndirectContainer) e.getPhones();
container.setValueHolder( null );
e.setPhones( null );