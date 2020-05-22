Empty creature = null; //Empty can be the variable type, it's the parameter type in the insertEnd method
if(runTypes[k] == EMPTY) {
     creature = new Empty(); //no problem, it's the same class
} else if(runTypes[k] == FISH) {
     creature = new Fish(); //no problem, Fish is a subclass
} else if (runTypes[k] == SHARK) {
     creature = new Shark(starveTime); //no problem, Shark is a subclass of Empty
}
DLinkedList.insertEnd(creature, runLengths[k]);