// temp is initialized to start at first
while(temp != 0){
    rem = temp % 10;
    rev = rev * 10 + rem;
    temp = temp / 10;
}
// at the end of this temp's value is entirely changed.
// above temp is incremented here, ideally temp at the start should be incremented. You can do this by initializing temp as i
temp++;