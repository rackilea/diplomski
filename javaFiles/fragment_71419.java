public void pickUp(Container in)
{
    moveContainer(in, playerContainer);
}

public void dropContainer (Container out)
{
   moveContainer(playerContainer, out);
}

public void moveContainer(Container from, Container to) {
    if (to.returnSomething() == null) {
        to.setSomething(from.returnSomething());
        from.setSomething(null);
    }
}