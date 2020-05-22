public void mouseDragged(MouseEvent e)
{
    if (first) { // this is only true if it's first drag
        System.out.println("This is the first drag");
        first=false;
    }
    else {
        System.out.println("This isn't the first drag");
    }

}