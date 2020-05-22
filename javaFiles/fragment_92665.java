for (rect_x ...) {
label:       for (rect_y...) {
                 for (x = 0; ...) {
                     for (y = 0; ....) {
                         if (mismatch) {
                             continue label;
                         }
                      }
                 }
                 return "match";
             }
         }
         return null;