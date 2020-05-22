protected void fireActionPerformed() {
    if (!listeners.isEmpty()) {

        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "LukeButton");
        for (ActionListener listener : listeners) {
            listener.actionPerformed(evt);
        }

    }
}