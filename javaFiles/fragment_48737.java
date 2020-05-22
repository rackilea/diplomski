public class Train {

    public void print ()
    {
        // here you might have a default printing logic, or you could keep this
        // method abstract and leave the implementation to the sub-classes
    }

}

public class Sprinter extends Train {

    @Override
    public void print ()
    {

    }

}

public class InterCity extends Train {

    @Override
    public void print ()
    {

    }

}