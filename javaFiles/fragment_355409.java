double interval = 304.8;
double prev = // saved from the previous round
double curr = prev + someIncrement();
if (Math.floor(curr/interval) > Math.floor(prev/interval)) {
    milestonePassed();
}
prev = curr; // For next round