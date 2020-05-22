@Override
public void componentResized(ComponentEvent e) {
    String str = "";
    if (getWidth() < 1000) {
        str = "0." + getWidth();
    } else {
        str = "1." + (getWidth()-1000);
        System.out.println(getWidth()-1000);
    }
    double dou = Double.parseDouble(str);
    canvas.scale = dou;
}