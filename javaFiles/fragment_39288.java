int id = 0;
while (true) {
    switch (id) {
        case 0:
            //do stuff
            if (condition) {id = 3; break;} //jumps to case 3:
        case 1:
            if (condition) {id = 1; break;} //jumps to case 1:
        // ...
    }
}