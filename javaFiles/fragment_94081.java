todo = [starting_book]
path = {starting_book: None}
while len(todo) and target_book not in path:
    book = list.pop(0)
    for next_book in neighbors(book):
        if next_book not in path:
            path[next_book] = book
            todo.append(next_book)
if target_book in path:
    solution = [target_book]
    while solution[-1] != starting_book:
        solution.append(path[solution[-1]])
else:
    solution = None