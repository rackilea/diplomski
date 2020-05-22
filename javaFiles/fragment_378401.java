if (i == 256)
{
    display.setValue(0);
    box.setText("0");
    i = 0; // <-- in case something else depends on i
}