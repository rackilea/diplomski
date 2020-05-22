boolean doDefault = false;
switch(num) {
    case 1:
        if(foo) {
            ...
        }
        else {
            doDefault = true;
        }
        break;
}

if(doDefault) {
    //do something
}