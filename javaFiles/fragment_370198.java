List<SWTBotToolbarButton> items = view.getToolbarButtons();
for (SWTBotToolbarButton button : items) {
    if (MyAction.TITLE.equals(button.getToolTipText())) {
        button.click();
        break;
    }
}