long differenceSeconds = (end.getTime() - start.getTime()) / 1000;
long differenceHours = differenceSeconds / 3600;
// discount the total hours
differenceSeconds -= (differenceHours * 3600);
long differenceMinutes = differenceSeconds / 60;
// discount the total seconds
differenceSeconds -= (differenceMinutes * 60);