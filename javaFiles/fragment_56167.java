String namePlaylist = JOptionPane.showInputDialog("Enter Playlist name :");
File inPlayList = new File(namePlaylist);
String newName = JOptionPane.showInputDialog("Enter new Playlist name :");
                 
                    File newF = new File(newName);
                    inPlayList.renameTo(newF);
                    inPlayList = newF;