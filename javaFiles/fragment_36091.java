public void setSpriteSheetPosition(int columns, int rows, int which_column, int which_row, int wide, int tall)
{
    this.columns = columns; //Number of columns the sprite sheet has
    this.rows = rows;  //Number of rows the sprite sheet has.
    this.which_column = which_column; //Which column and row I want to display on the Sprite
    this.which_row = which_row;
    this.wide = wide; //How many cells wide I want the sprite to be composed of
    this.tall = tall; //How many cells tall I want the sprite to be composed of
}