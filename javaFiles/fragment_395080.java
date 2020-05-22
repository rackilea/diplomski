InputProcessor backProcessor = new InputAdapter()
        {
            @Override
            public boolean keyDown(int keycode)
            {
                //do stuff
                return false;
            }
        };
multiplexer.addProcessor(backProcessor);