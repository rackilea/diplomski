Properties properties = new Properties();
FileInputStream fin = null;
FileOutputStream fout = null;
fin  = new FileInputStream(mCallback.getConfFile());
// if fout was here, the file would be cleared and reading from it would produce no properties
properties.load(fin); 
properties.setProperty(Wrapper.GAME_PATH_KEY, (String)gamePathText.getText());
properties.setProperty(Wrapper.GAME_TYPE_KEY, (String)selectedGame.getSelectedItem());

fout  = new FileOutputStream(mCallback.getConfFile());

properties.store(fout, null);