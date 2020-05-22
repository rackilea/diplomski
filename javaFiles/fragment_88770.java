ArrayList<String> pc_list = new ArrayList<>();
ArrayList<String> pc_offline_list = new ArrayList<>();

// . . .

switch (status) {
    case "online":
        //This is just for rendering an image+text to Jlist
        icons.put(comb, new ImageIcon(getClass().getResource("/Imagenes/com_on_30x30.png")));
        pc_list.add(comb);
        break;
    case "offline":
         //This is just for rendering an image to Jlist
        icons.put(comb, new ImageIcon(getClass().getResource("/Imagenes/com_off_30x30.png")));
        pc_offline_list.add(comb);
        break;
}

// . . .

pc_list.addAll(pc_offline_list);
Home.computer_jlist.setListData(pc_list.toArray());