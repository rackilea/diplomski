...
else if (count == 12) {
    lights[2].toggle();
    lights[0].toggle();
    count = 0;
    ((Timer)e.getSource()).stop();
}