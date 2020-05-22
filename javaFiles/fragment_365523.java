i = 0; secondCount = 0;
{1, 2, 1, 2, 3} {1, 2, 3}
 ^               ^
 1 == 1 ? true

i = 1; secondCount = 1;
{1, 2, 1, 2, 3} {1, 2, 3}
    ^               ^
 2 == 2 ? true

i = 2; secondCount = 2;
{1, 2, 1, 2, 3} {1, 2, 3}
       ^               ^
 1 == 3 ? false

i = 3; secondCount = 0;
{1, 2, 1, 2, 3} {1, 2, 3}
          ^      ^
 2 == 1 ? false

i = 3; secondCount = 0;
{1, 2, 1, 2, 3} {1, 2, 3}
             ^   ^
 3 == 1 ? false

return false;