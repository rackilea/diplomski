Window window = new Window();
window.setModal(true);
window.addCloseShortcut(KeyCode.ESCAPE, null);
UI.getCurrent().addWindow(window);
Image anImage = ...
window.setContent(anImage);
anImage.setSizeFull();
window.setSizeFull();