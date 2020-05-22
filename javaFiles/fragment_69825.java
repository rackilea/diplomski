@Test
public void locationByInteger() throws FindFailed {

    Screen s = new Screen(0);

        int x = 100;
        int y = 100;

        s.click(new Location(x, y));

    }