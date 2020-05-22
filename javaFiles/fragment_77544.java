@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

MyDB db = new MyDB(mContext);

ArrayList<String> images1=db.getCollection(position);
for(int i=0;i<images1.size();i++){
    String path1=images1.get(i);
    holder.imgs[i].setImageURI(Uri.parse(path1));

}
@override
int getItemCount(){
    return 6;
}