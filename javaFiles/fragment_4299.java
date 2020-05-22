long initialTime = System.currentTimeMillis();
long now = System.currentTimeMillis();
while(now - initialTime < 2000){
    now = System.currentTimeMillis();
}
//now code after two seconds..
mainList.add(item);
adapter.notifyItemInserted();