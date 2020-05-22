boolnea isOnLeft = starW <= (.5 * dimension[0]);
boolean isOut = starH <= 0;

if (star[a] instanceof fourStar) {
  if (isOnLeft && isOut) {
  ...
  }
} else { //3ps
  if (!isOnLeft && isOut) {
  ...
  }
}