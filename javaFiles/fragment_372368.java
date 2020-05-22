int func1val = func1();
if (checkIfTrue(func1val)) {
    int func2val = func2();
    if (checkIfTrue(func2val)) {
        int func3val = func3();
        if (checkIfTrue(func3val)) {
            // print func1val, func2val, func3val
        }
    }
}