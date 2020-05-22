public void doSomething(){      
    // change the actual Image and schedule next image change
    actualImage = Sequence[actualSequenceId].Image;
    scheduleTask(Sequence[actualSequenceId].Duration);

    // increment sequence Id
    if(actualSequenceId + 1 == Sequence.length) actualSequenceId = 0;
    else actualSequenceId++;
}