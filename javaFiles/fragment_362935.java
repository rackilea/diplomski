final int x;
if (maybeTrueOrMaybeFalse()) {
   x = 1;
}
/* error: variable x might already have been assigned */
x = 1;