public void pourCup(Cup source, Cup target) {

    int spaceInTargetCup = target.cupSize - target.cupLevel;

    if (source.cupLevel <= spaceInTargetCup) {
        // there's room to pour all the contents of the source cup into the target cup
        target.cupLevel += source.cupLevel; // add the contents of source to the target
        source.cupLevel = 0; // the source is now empty
    } else {
        // there's not enough room to pour all the contents of the source in
        source.cupLevel -= spaceInTargetCup; // empty as much as you can from the source
        target.cupLevel = target.cupSize; // the target is now full
    }
}