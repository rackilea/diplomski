class ChangeFoo {
    ChangeFoo (Bar bar, foo newFoo){}
    void execute(){
        oldFoo = bar.getFoo();
        bar.setFoo(newFoo);
    }
    void undo(){
        bar.setFoo(oldFoo);
    }
 }