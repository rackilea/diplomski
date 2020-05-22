//if you have the Volume ArrayList
VolumeTableModel myTableModel = new VolumeTableModel(volumesArrayList);
//if you dont have the Volume ArrayList
VolumeTableModel myTableModel = new VolumeTableModel();
myTableModel.addVolume(volume);
JTable table = new JTable(myTableModel);