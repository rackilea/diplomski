main: for (News n : c) {
    ...
    for (News ex : this) {
        if (n.id == ex.id) {
            ...
            // Break the loop with the label main
            break main;
        }
    }
    ...
}