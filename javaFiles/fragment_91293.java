ActionEvent evt = new ActionEvent(
                TICK_HOUR, 
                0, 
                TICK_HOUR.getActionCommand(), 
                System.currentTimeMillis(),
                0);
for (ActionListener listener : TICK_HOUR.getActionListeners()) {
    listener.actionPerformed(evt);
}