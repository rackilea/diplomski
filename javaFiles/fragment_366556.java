public interface TodoRepository {
    int save(Todo todo);

    Todo findById(int totoId);
}

@Repository
public class InMemoryTodoRepository implements TodoRepository {
    private Map<int, Todo> todos = new HashMap<>();

    public Todo save(Todo todo) {
        int newId = // generate new Id;
        todos.put(newId, todo)
        return newId;
    }

    public Todo findById(int totoId) {
        return todos.get(todoId);
    }
}