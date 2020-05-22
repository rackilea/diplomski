boolean finished = false;
Student s;

while (!finished) {
    s = getStudentForIndex(getInput());
    if (s != null)
        finished = true;
}

// Do stuff with the Student s here.