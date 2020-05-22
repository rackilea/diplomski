List<Video> list = VideoData.getVideoList();

JList videolist = new JList();

Vector<Video> data = new Vector<Video>();  
for (int i=0; i < list.size(); i++) {
    Video video = list.get(i);
    data.addElement(video);
}

videolist.setListData(data);
videolist.setSelectedIndex(0);
videolist.addMouseListener(new ActionJList(videolist));
videolist.setFixedCellWidth(300);
add(new JScrollPane(videolist));