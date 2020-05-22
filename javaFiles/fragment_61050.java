const GRAVITY = 10;
const TERMINAL_VELOCITY = 300;

object Player 
{
    int vertical_speed = 0;
    int vertical_position;  

    function fall ()
    {
        this.vertical_speed = this.vertical_speed + GRAVITY;
        if (this.vertical_speed > TERMINAL_VELOCITY)
        {
            this.vertical_speed = TERMINAL_VELOCITY;
        }
        this.vertical_position = this.vertical_position - this.vertical_speed;
    }
}