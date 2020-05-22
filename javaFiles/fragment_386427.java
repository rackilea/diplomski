public void mouseDragged(java.awt.event.MouseEvent evt) {
        draging = true;
        if (mark) {
            if (first) {
                System.out.println("This is the first drag");
            }else{
                System.out.println("This isn't the first drag");
            }
            mark = false;
        }
}