@Override
public View getView(int position, View convertView, ViewGroup parent) {
LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View rowView = inflater.inflate(list_resourceID, parent, false);
final ImageView hotel_pic = (ImageView) rowView
        .findViewById(R.id.imageView_hotel_1);
TextView hotel_name = (TextView) rowView
        .findViewById(R.id.textview_hotel_1);
TextView hotel_name_descrip = (TextView) rowView
        .findViewById(R.id.textview_hotel_descrip);
String hotel = List_Filler.GetbyId(position).getHotel_name();
String descri = List_Filler.GetbyId(position).getShort_description();
hotel_name.setText(hotel);
hotel_name_descrip.setText(descri);
String temp_url;
StringTokenizer tokens = new StringTokenizer(List_Filler.GetbyId(
        position).getHotel_imgs(), "[\"");
do {
    temp_url = (String) tokens.nextElement();
} while (false);


temp_url = "http://" + temp_url.replace("\","");
Bitmap temp = null;
try {
     if (temp_url.length() > 5) {                   
         temp = BitmapFactory.decodeStream((InputStream)new URL(temp_url).getContent());
     }
 } catch (IOException e) {
     e.printStackTrace();
 }
 hotel_pic.setImageBitmap(temp);

 return rowView;
}