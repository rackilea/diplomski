class Window
{
    // ...

    void draw_window()
    {
        if (win_selected == my_id)
        {
          fill(60);
        }
        else
        {
          fill(40);
        }
        rect(winX, winY, winW, winTH);

        fill(25);
        rect(winX, winY + 24, winW, winH);
    }

    void update_window()
    {
       if (dragging == true)
       { 
          // ...
       }

       // ...
    }