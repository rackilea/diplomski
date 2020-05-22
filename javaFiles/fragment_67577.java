switch (e.getKeyCode())
{
        case KeyEvent.VK_A :
            if(e.isControlDown())
               System.out.println("A and Ctrl are pressed.");
            else
                System.out.println("Only A is pressed");
            break;
        ...
}