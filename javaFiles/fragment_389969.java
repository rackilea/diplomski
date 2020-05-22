public class DtoRepository<T> {

    public void update(T t) {
        System.out.println(t.getClass().getSimpleName() + " updated..");
    }

    public void updatePerson(T t, Set<String> updatedFields) {
        System.out.print("Updated the following fields on " +
            t.getClass().getSimpleName() + " in the repository: "
            + updatedFields);       
    }
}