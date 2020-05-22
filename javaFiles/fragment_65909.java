arr_fav = {"1","2","3"};
List<String> numlist = new ArrayList<String>();
for(int i= 0;i<arr_fav.length;i++)
{
 if(current_id == Integer.parseInt(arr_fav[i]))
 {
   // No operation here 
 }
 else
 {
     numlist.add(arr_fav[i]);
 }
}
 arr_fav = numlist .toArray(new String[numlist .size()]);