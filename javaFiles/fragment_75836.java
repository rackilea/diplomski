// Move first
position = position + direction;

// Boundary check second...
if (position > 5)
{
     position = 5;
     direction *= -1
}
else if (position < -5)
{
     position = -5;
     direction *= -1
}

gun1.move(direction);
gun2.move(direction);