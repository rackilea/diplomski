@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    ChannelList cl = new ChannelList();
    cl.createList();

  //determine JList by JCombobox selecton
    genre = c.getSelectedItem().toString();

    if(e.getSource() == c){
        vt1.clear();
        for(int i =0; i < cl.chList.length; i++){
            char chGenre = cl.chList[i].getChGenre();
            switch(genre){
            case "Please Select Genre of Channel":
                lchannels.setListData(vt1);
                break;
            case "All Genres":
                vt1.add(cl.chList[i].getChTitle());
                lchannels.setListData(vt1);
                break;
            case "Entertainment":
                if(chGenre == 'e'){
                    vt1.add(cl.chList[i].getChTitle());
                    lchannels.setListData(vt1);
                }
                break;
            case "Movie":
                if(chGenre == 'm'){
                    vt1.add(cl.chList[i].getChTitle());
                    lchannels.setListData(vt1);
                }
                break;
            case "News/Business":
                if(chGenre == 'n'){
                    vt1.add(cl.chList[i].getChTitle());
                    lchannels.setListData(vt1);
                }
                break;
            case "Sci-Fi":
                if(chGenre == 's'){
                    vt1.add(cl.chList[i].getChTitle());
                    lchannels.setListData(vt1);
                }
                break;
            case "Sports":
                if(chGenre == 't'){
                    vt1.add(cl.chList[i].getChTitle());
                    lchannels.setListData(vt1);
                }
                break;
            }
        }
    }
}