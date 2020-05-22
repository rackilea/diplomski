ArrayList list = getListValue();
listBoc.Items.clear();
for(int i = 0;i<list.size();i++){
                System.out.println("qsdq " +list.toString()+" "+ list.size());
                listBox.addItem(list.get(i));
            }