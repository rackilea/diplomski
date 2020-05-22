public class GroupDecorator extends GraphicObject { //or extends whatever is best
    public GroupDecorator(Group wrappedGroup) { 
        myGroup = wrappedGroup;
    }

    public void paint() { //Assume this is your common paint() method
        //note I'm making up the names here, since I don't know them
        List groupsChildren = myGroup.getChildren(); 

        //The type of alignment is stored somewhere in this object
        //or is hard-coded. That's up to you. I'll assume it's stored somewhere...

        if (isAlignedLeft()) { 
          //align all the children to the left here
        } else if (isAlignedRight()){
          //align all the children to the right here
        } else { 
          //do nothing because no alignment is necessary
        }

        //call the wrapped Group's paint now. It will call its children's paint()s.
        myGroup.paint();

        //Unalign all the children here, if necessary, to put them back in 
        //their original state. How you implement that is up to you.
    }

}
// Somewhere in your main code...

    mainGroup = new Group();

    //Decorate mainGroup now...
    GroupDecorator decoratedGroup = new GroupDecorator(mainGroup);
    //Configure decoratedGroup to align however you want.

    // first line
    GraphicObject rect1 = new Rectangle();
    mainGroup.addChild(rect1);

    // other lines...

    // fifth line
    GraphicObject rect5 = new Rectangle();


    //Now use decoratedGroup now in place of mainGroup.