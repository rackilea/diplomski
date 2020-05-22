HashSet<String> all_ids=new HashSet<String>();

if (!all_ids.contains(jsonObject.getString("hood_name"))) 
{
    points.add(new Points(jsonObject.getString("hood_name"), jsonObject.getDouble("points"), jsonObject.getInt("hood_id")));
    all_ids.add(jsonObject.getString("hood_name")); //You need to add it to set as Now it exists in the list.                     
}