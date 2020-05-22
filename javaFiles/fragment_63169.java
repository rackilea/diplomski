// MAIN_WINDOW = my main JFrame
// SUBMENU = my pseudo submenu that overlaps on top of everything else
// ADDOBJECTS = actual JPanel with submenu-like buttons, positioned manually
// this is called from a "main" menu-like button
JPanel SUBMENU = (JPanel) MAIN_WINDOW.getGlassPane();
SUBMENU.setLayout(null);
SUBMENU.add(ADDOBJECTS);
SUBMENU.setVisible(true);