@Override
public void setVisible(boolean visible) {
    int widthHint = getControl().getSize().x - 16;

    l.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut"
              + "labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo"
              + "duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum"
              + "dolor sit amet.");
    ((GridData)l.getLayoutData()).widthHint = widthHint;

    getControl().pack();

    super.setVisible(visible);
}