open 1, 2, 3 activities
1 > 2 > 3  

back to #2
1 > 2          // call startActivity for 2, don't call finish() in 3

open #4 activity
1 > 2 > 4

back to #2
1 > 2

restore #3 activity
1 > 2 > 3      // call startActivity for 3 with intent as Intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_To_FRONT);