// The size of the window.
Rectangle bounds = this.getBounds();

// How many rows of buttons.
int numOfRows = 100;

// How many buttons per row.
int numOfColumns = 50;

int buttonWidth = bounds.width / numOfRows;
int buttonHeight = bounds.height / numOfColumns;

int x = 0;
int y = 0;

for(int i = 0; i < numOfColumns; i++){
    for(int j = 0; j < numOfRows; j++){
        // Make a button
        button.setBounds(x, y, buttonWidth, buttonHeight);
        y += buttonHeight;
    }
    x += buttonWidth;
}