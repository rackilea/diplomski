// CREATE NEW TODOITEM FROM SENT JSON
@PostMapping("/todos/new")
public String newToDo(@RequestBody TodoItem todoItem) {
    String title = todoItem.getTitle(); // extract title
    LocalDate dueDate = todoItem.getDueDate; // extract dueDate

    // getting logged in user
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userFromDb = userRepository.findOne(currentUser.getId());


    ToDoItem newToDoItem = new ToDoItem(userFromDb, title, dueDate);