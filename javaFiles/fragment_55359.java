JTextField tf = (JTextField) FrameUtils
                    .getComponentById(
                            instance.getContentPane(), "reg_r"
                                    + i);
            Component c = (Component) getFocusOwner();
            if (c == null || !tf.getName().equals(c.getName())) {
            // JTextField is not focused/being edited, proceed with update
            tf.setText(...);
            }