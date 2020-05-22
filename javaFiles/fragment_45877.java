int pattern = (cb1.isSelected() ? 0b0001 : 0)
            | (cb2.isSelected() ? 0b0010 : 0)
            | (cb3.isSelected() ? 0b0100 : 0) 
            | (cb4.isSelected() ? 0b1000 : 0);

switch (pattern) {
    case 0b0001:
        // code for when only checkbox 1 is checked 
        break;
    ...
    case 0b0011:
        // code for when checkbox 1 and checkbox 2 are checked
        break;
    ...
    case 0b1011:
        // code for when only checkbox 1, 2 and 4 are checked
        break;
    ...
}