interface Entity {
    public boolean isActive ();
    public void think (); // think returns nothing
    public void paint (Graphics g);
}

// then in your main update loop:
List<Entity> entities = ...;
for (Entity e:entities)
    if (e.isActive())
        e.think();
// it is the responsibility of something outside the ball to restore it to an
// active state, since think() isn't called if !isActive(). alternatively, you 
// could always call think(), and just don't paint inactive balls.

// and in paint:
for (Entity e:entities)
    if (e.isActive())
        e.paint(graphics);