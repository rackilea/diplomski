JFrame frame = ...;
JPanel panel = ...;
if (DEBUG_REPAINT) {
    JXLayer<JPanel> layer = new JXLayer<>(panel);
    DebugRepaintingUI dp = new DebugRepaintingUI(50); // 50ms delay
    layer.setUI(dp);
    frame.setContentPane(layer);
}
else {
    frame.setContentPane(panel);
}                   }