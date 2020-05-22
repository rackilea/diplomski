public void onClick(DialogInterface dialog, int which) {
    if (dialog == renderView.getLosingDialog()) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            // TODO: Polish the dialog.
            // TODO: Add a method of obtaining the score from RenderView.
            renderView.getStage().reset();
            renderView.setDialogFlag(false);
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            PlayActivity.this.onBackPressed();
        }
    } else if dialog == renderView.getWinningDialog()) {
        // etc...
    } else if dialog == renderView.getPausingDialog()) {
        // etc...
    }
}