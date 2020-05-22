int[] itemWindowLocation = new int[2];
menuItemView.getLocationInWindow(itemWindowLocation);

int[] toolbarWindowLocation = new int[2];
toolbar.getLocationInWindow(toolbarWindowLocation);

int itemX = itemWindowLocation[0] - toolbarWindowLocation[0];
int itemY = itemWindowLocation[1] - toolbarWindowLocation[1];
int centerX = itemX + menuItemView.getWidth() / 2;
int centerY = itemY + menuItemView.getHeight() / 2;