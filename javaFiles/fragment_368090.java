SpringLayout layout = new SpringLayout();
setLayout(layout);

SpringLayout.Constraints jb1Constraints =
    new SpringLayout.Constraints(jb1);

SpringLayout.Constraints jb2Constraints =
    new SpringLayout.Constraints(
        Spring.sum(jb1Constraints.getX(), jb1Constraints.getWidth()),
        jb1Constraints.getY(),
        Spring.scale(jb1Constraints.getWidth(), 2),
        Spring.scale(jb1Constraints.getHeight(), 2));

SpringLayout.Constraints jb3Constraints =
    new SpringLayout.Constraints(
        Spring.sum(jb2Constraints.getX(),
                   Spring.scale(jb2Constraints.getWidth(), 0.5f)),
        Spring.sum(jb2Constraints.getY(), jb2Constraints.getHeight()),
        Spring.scale(jb1Constraints.getWidth(), 5),
        Spring.scale(jb1Constraints.getHeight(), 5));

add(jb1, jb1Constraints);
add(jb2, jb2Constraints);
add(jb3, jb3Constraints);

// Make container big enough to hold all components.

layout.putConstraint(
    SpringLayout.EAST, getContentPane(), 0,
    SpringLayout.EAST, jb3);

layout.putConstraint(
    SpringLayout.SOUTH, getContentPane(), 0,
    SpringLayout.SOUTH, jb3);