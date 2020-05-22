/* Gets a list of the controllers JInput knows about and can interact with */
    Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

    for(int i =0;i<ca.length;i++){

        /* Get the name of the controller */
        System.out.println(ca[i].getName());

        /* Gets the type of the controller, e.g. GAMEPAD, MOUSE, KEYBOARD */
        System.out.println("Type: "+ca[i].getType().toString());

        /* Get this controllers components (buttons and axis) */
        Component[] components = ca[i].getComponents();
        System.out.println("Component Count: "+components.length);
        for(int j=0;j<components.length;j++){

            /* Get the components name */
            System.out.println("Component "+j+": "+components[j].getName());

            /* Gets its identifier, E.g. BUTTON.PINKIE, AXIS.POV and KEY.Z */

            System.out.println("    Identifier: "+ components[j].getIdentifier().getName());

            /* Display if component is relative, absolute, analog, digital */
            System.out.print("    ComponentType: ");
            if (components[j].isRelative()) {
                System.out.print("Relative");
            } else {
                System.out.print("Absolute");
            }
            if (components[j].isAnalog()) {
                System.out.print(" Analog");
            } else {
                System.out.print(" Digital");
            }
        }
    }