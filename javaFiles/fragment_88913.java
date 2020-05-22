interface Entity {
    public boolean think ();
    public void paint (Graphics g);
}

class Ball implements Entity {
    @Override public boolean think () {
        // return true if alive, false if dead
    }
    @Override public void paint (Graphics g) {
        // draw this ball
    }
}

// then in your main update loop:
List<Entity> entities = ...;
Iterator<Entity> eit = entities.iterator();
while (eit.hasNext())
    if (!eit.next().think()) 
        eit.remove();

// and in paint:
for (Entity e:entities)
    e.paint(graphics);