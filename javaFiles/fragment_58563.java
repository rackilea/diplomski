// Random size, minimum size of 10, maximum size of 50
randomW = 10 + (Math.random() * 40);
randomH = 10 + (Math.random() * 40);

// Get the components insets
Insets insets = getInsets();
// Calculate the available size by subtract the sum of the margins...
int width = getWidth() - (insets.left + insets.right);
int height = getHeight() - (insets.top + insets.bottom);

// Calculate a postion that is at minimum, the top/left margin
// but less than the available space minus the size of the shape...
randomX = insets.left + (Math.random() * (width - randomW));
randomY = insets.top + (Math.random() * (height - randomH));