final long availableSequence = sequenceBarrier.waitFor(nextSequence);
while (nextSequence <= availableSequence)
{
    event = dataProvider.get(nextSequence);
    eventHandler.onEvent(event, nextSequence, nextSequence == availableSequence);
    nextSequence++;
}