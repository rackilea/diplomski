secondsInMillis = time % (60 * 1000) //get remainder (modulo): seconds * milliseconds
if (secondsInMillis < 30000) {
  time -= secondsInMillis; //round down
} else {
  time += (60000 - secondsInMillis); // round up
}