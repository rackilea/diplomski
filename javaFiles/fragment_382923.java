TextInputListener textListener = new TextInputListener()
    {
        @Override
        public void input(String input)
        {
            System.out.println(input);
        }

        @Override
        public void canceled() 
        {
            System.out.println("Aborted");
        }
    };

    Gdx.input.getTextInput(textListener, "Your login: ", "placeholder", "");