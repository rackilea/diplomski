private static final Dimension DESIRED_SIZE = new Dimension(600, 600);
private int width = 80, height = 80;

public TestPane() {
}

@Override
public Dimension getPreferredSize() {
    return DESIRED_SIZE;
}