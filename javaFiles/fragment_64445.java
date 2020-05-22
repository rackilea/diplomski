String MessageType = reader.next();
int IsAdd = MessageType.compareToIgnoreCase("A");
int IsCancel = MessageType.compareToIgnoreCase("X");
// .... left out other classes

//if the type of order is add order to existing Order Book
if (IsAdd == 0){
    // .. do stuff
}