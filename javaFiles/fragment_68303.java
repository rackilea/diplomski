String jsonStr ="[{\"id\":\"1\",\"name\":\"Bodrum\",\"program\":null,\"program_link\":null,\"images_array\":[\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f3fde123b.jpg\",\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f3fde20d4.jpg\",\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f3fde21c6.jpg\",\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f43b43e37.jpg\"],\"hotels\":[{\"id\":\"3\",\"city_id\":\"1\",\"name\":\"Bodrum Hotel\",\"images_array\":[]}]},{\"id\":\"2\",\"name\":\"Bursa\",\"program\":null,\"program_link\":null,\"images_array\":[\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f4ff167a8.jpg\",\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f4ff168e1.jpg\",\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f4ff169cb.jpg\"],\"hotels\":[{\"id\":\"4\",\"city_id\":\"2\",\"name\":\"Bursa Hotel\",\"images_array\":[]}]},{\"id\":\"3\",\"name\":\"Istanbul\",\"program\":null,\"program_link\":null,\"images_array\":[\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f5d1927ce.jpg\"],\"hotels\":[{\"id\":\"2\",\"city_id\":\"3\",\"name\":\"Istanbul Hotel\",\"images_array\":[]}]},{\"id\":\"4\",\"name\":\"Bolu\",\"program\":null,\"program_link\":null,\"images_array\":[\"http:\\/\\/dev.booking.blancatours.com\\/uploads\\/53d1f8f500afc.jpg\"],\"hotels\":[]},{\"id\":\"5\",\"name\":\"Trabzon\",\"program\":null,\"program_link\":null,\"images_array\":[],\"hotels\":[]},{\"id\":\"6\",\"name\":\"Yalova\",\"program\":null,\"program_link\":null,\"images_array\":[],\"hotels\":[]},{\"id\":\"7\",\"name\":\"Sapanca\",\"program\":null,\"program_link\":null,\"images_array\":[],\"hotels\":[]},{\"id\":\"8\",\"name\":\"Antalya\",\"program\":null,\"program_link\":null,\"images_array\":[],\"hotels\":[]}]";
try {
     JSONArray jsonArr = new JSONArray(jsonStr);

     ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();
     for (int i = 0; i < jsonArr.length(); i++) {
          HashMap<String, Object> destiMap = new HashMap<String, Object>();
          destiMap.put("id", jsonArr.getJSONObject(i).getString("id"));
          destiMap.put("name", jsonArr.getJSONObject(i).getString("name"));
          destiMap.put("program", jsonArr.getJSONObject(i).getString("program"));
          destiMap.put("program_link", jsonArr.getJSONObject(i).getString("program_link"));

          ArrayList<String> images = new ArrayList<String>();
          JSONArray imagesJsonArray = jsonArr.getJSONObject(i).getJSONArray("images_array");
          for(int j=0;j<imagesJsonArray.length();j++){
              images.add(imagesJsonArray.getString(j));
          }
          destiMap.put("images_array", images);

          ArrayList<HashMap<String,Object>> hotels = new ArrayList<HashMap<String,Object>>();
          JSONArray hotelsJsonArray = jsonArr.getJSONObject(i).getJSONArray("hotels");
          for(int j=0;j<hotelsJsonArray.length();j++){
              HashMap<String,Object> hotelMap = new HashMap<String, Object>();
              hotelMap.put("id",hotelsJsonArray.getJSONObject(j).getString("id"));
              hotelMap.put("city_id",hotelsJsonArray.getJSONObject(j).getString("city_id"));
              hotelMap.put("name",hotelsJsonArray.getJSONObject(j).getString("name"));

              ArrayList<String> hotelImages = new ArrayList<String>();
              JSONArray hotelImagesJsonArray = hotelsJsonArray.getJSONObject(j).getJSONArray("images_array");
              for(int k=0;k<hotelImagesJsonArray.length();k++){
                  hotelImages.add(hotelImagesJsonArray.getString(k));
              }
              hotelMap.put("images_array", hotelImages);
              hotels.add(hotelMap);
           }
           destiMap.put("hotels",hotels);
           list.add(destiMap);
      }

      for (HashMap<String,Object> desti : list){
           System.out.print("Desti id : " + desti.get("id"));
           System.out.print("Desti name : " + desti.get("name"));
           System.out.print("Desti program : "+desti.get("program"));
           System.out.print("Desti program_link : " + desti.get("program_link"));
           System.out.print("Desti images_array size : "+((ArrayList<String>)desti.get("images_array")).size());
           ArrayList<HashMap<String,Object>> hotels = (ArrayList<HashMap<String,Object>>) desti.get("hotels");
           for (HashMap<String,Object> hotel : hotels){
                System.out.print("hotel id : " + hotel.get("id"));
                System.out.print("hotel city_id : " + hotel.get("city_id"));
                System.out.print("hotel name : "+hotel.get("name"));
                System.out.print("hotel images_array size : "+((ArrayList<String>)hotel.get("images_array")).size());
           }
      }
} catch (JSONException e) {
      e.printStackTrace();
}


public class DestinationAdapter extends BaseAdapter {
    public ArrayList<HashMap<String, Object>> detArray;
    private Context mContext;
    private DisplayImageOptions options;
    public static ImageLoader imageLoader;

    @SuppressWarnings("deprecation")
    public DestinationAdapter(Context paramContext,ArrayList<HashMap<String, Object>> list) {
        this.mContext = paramContext;
        this.detArray = list;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(paramContext));
        options = new DisplayImageOptions.Builder().cacheOnDisc(true)
                .showStubImage(R.drawable.noimage)
                .showImageOnFail(R.drawable.noimage).build();
    }

    public int getCount() {
        return detArray.size();
    }

    public Object getItem(int pos) {
        return detArray.get(pos);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int position, View view, ViewGroup paramViewGroup) {
        Viewholder holder;
        if (view == null) {
            holder = new Viewholder();
            view = LayoutInflater.from(mContext).inflate(R.layout.raw_dest, paramViewGroup, false);
            holder.destImg = (ImageView) view.findViewById(R.id.iv_dest);
            holder.destName = (TextView) view.findViewById(R.id.tv_city);
            view.setTag(holder);
        } else {
            holder = (Viewholder) view.getTag();
        }
        holder.destName.setText((String)detArray.get(position).get("name"));
        holder.destName.setText((String)detArray.get(position).get("name"));
        ArrayList<String> images = (ArrayList<String>)detArray.get(position).get("images_array");
        if(images!=null && images.size()>0){
            imageLoader.displayImage(images.get(0),holder.destImg, options);
        }
        return view;
    }

    class Viewholder {
        ImageView destImg;
        TextView destName;
    }
}