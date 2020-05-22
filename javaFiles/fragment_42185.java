else if(keyCode == KeyEvent.VK_Z)
{
    Oval o = new Oval(x + radius, y + radius, 2 * radius, 2 * radius);
    ovals.add(o); // where ovals is an ArrayList<Oval> or LinkedList<Oval>
    g.fillOval(o.x, o.y, o.width, o.height);
}