float timer;

timer += delta;
if (timer >= 1) {
    time++;
    timePoint.setSentence(""+time);
    timer -= 1;
}