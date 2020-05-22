// ...
// remove j and k
int y = year;
// ...
// reformatted for readability
int h = (q +
         (int)((26 * (m + 1)) / 10.0) +
         y +
         (int)(y / 4.0) +
//       changes after here
         6 * (int)(y / 100.0) +
         (int)(y / 400.0))
        % 7;