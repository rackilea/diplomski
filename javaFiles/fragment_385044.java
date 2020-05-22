MouseListener mouseLtnr = new MouseAdapter()
{

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

        counter++;

        xs.add(MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x);
        ys.add(MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y);

        System.out.println(xs.get(counter-1) + " , " + ys.get(counter-1));

        if(flag == false)
        repaint();

    }
 }