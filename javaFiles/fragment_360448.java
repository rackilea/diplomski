class SplitFunction{
    public static void main(String args[]) throws Exception{

      String file_string = "";
      file_string = "Dan Stedman,07895 678909,INVITED;Dan Stedman,07895 678909,INVITED;Dan Stedman,07895 678909,INVITED;";
      String parse_array[] = file_string.split(";");///splits into individual People_Attendance items.
      String item_name; String item_number; String item_status; ///declares all the item strings

      for(String person_item : parse_array){
        String item_parse_array[] = person_item.split(",");
        item_name = item_parse_array[0];
        item_number = item_parse_array[1];
        item_status = item_parse_array[2];
        System.out.println(item_status);
      }
    }
  }