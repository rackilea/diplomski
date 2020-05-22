int nbClicks = 0;
...
// in your button's onClickListener
if(nbClicks == 0) {
  // do something
  nbClicks += 1;
} else if (nbClicks == 1){
  // do something else
  nbClicks += 1;
}
...