...

    float startX;

    DragListener listener = new DragListener()
    {
        public void dragStart(InputEvent event, float x, float y, int pointer)
        {
            startX = x;
        }

        public void drag(InputEvent event, float x, float y, int pointer)
        {   
            //x, y are delta from starting point so
            iBtnDrag.setPosition(startX + x, 448, Align.center);
        }

        public void dragStop(InputEvent event, float x, float y, int pointer)
        {
            //when stopping drag
        }
    };