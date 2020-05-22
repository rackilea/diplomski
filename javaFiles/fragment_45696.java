final long then = System.currentTimeMillis();
render(); // surely it's more than this but you get the idea
final long now = System.currentTimeMillis();

final long actualDuration = now - then;
final long sleepDuration = frameDuration - actualDuration;

if(sleepDuration > 0) {
    sleep(sleepDuration);
} else {
    throw new FrameTooLongException();
}