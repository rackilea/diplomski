// Y2 = Y + (Y = 0)
int Y2 = Y;
Y = 0;

// J2 = J + (J = 0)
int J2 = J;
J = 0;

// Note that, since we've just set Y and J to 0,
//   we may as well have used different variables

for (int i = 0; i < students.length; i++)
{
   int temp = (students[i] + J2 - 1) / J2;
   J = Math.max(J, -(Math.max(0, students[i] - Y2) + J2 - 1) / J2 + temp);
   Y += temp;
}
return Y-J;