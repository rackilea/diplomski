Branch start = new Branch();
CreateChildren(start);

const int ChildrenLimitCheck = 0;

private void CreateChildren(Branch parent) {

    //Use a limit variable so that you can decrease, and if it's equal to a sepcific number(usually 0) exit.
    int Limit = (int) (Math.random() * 5);
     //Call the function that's recursive, inside of a function that isn't recursive. This gives you a clean way to interface with the recursive function without excessive lines of code in other areas
     generateChildren(parent,Limit);

}

private void generateChildren(Branch parent,int limit) {

    //Check to see if we've hit our minimum. If so, exit out of the logic
    if(limit == ChildrenLimitCheck)
        return;

    //Specify the random number of branches created in this instance
    int numberOfBranches = (int) (Math.random() * 5);

    for (int i = 0; i < numberOfBranches; i++) {
        Branch child = new Branch(parent);
        parent.Children.Add(child);

        //Depending on what you want to do, either pass i or pass limit. If you don't use limit, you can remove it from this function :)
        //If you pass i, try doing:
        //for (int i = numberOfBranches; i > 0; i--)
        //So that you can eventually get down to 0, to automatically stop your recursive calls with the above return statement. 
        //Seems you just want to run a loop for xxx number of times. This will still grant that, but you won't have to guess the upper limit
        //of numberOfBranches to exit on, and you'll be able to exit cleanly
       //This may be what caused your stackoverflow error. For all recursive functions, you need an exit condition or it will run indefinately
        generateChildren(child,--limit);
        //generateChildren(child,i);
    }
}