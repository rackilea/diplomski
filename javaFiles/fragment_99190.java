for(int i=0; i<yourList.size(); i++) {
    yourList.get(i).setSelected(true);
}
Thread.sleep(500);
for(int i=0; i<yourList.size(); i++) {
    yourList.get(i).setSelected(false);
}
Thread.sleep(500);