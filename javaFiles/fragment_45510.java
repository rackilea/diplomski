@Override
public Dimension getPreferredSize() {

    int size = (int) (2 * mainCircler * ampRadius);
    return new Dimension(size, size);
}