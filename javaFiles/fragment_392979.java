private String getSearchLinks(String query, int start, int total) {
// assuming that initial page = 1, total = 0, and start is 0

   String result = "";
   int start = 0;

   if (total == 0) { return "";    // no links }

   Int page_size = 50;    // number of rows per page
   //page window - number of visible pagers per page
   Int window = 10;


   int pages = ceil(total / page_size );
   result = "Pages:";

   int current_page = (start / page_size ) + 1;
   //numeric value of current page ex. if start is 51 : 51/50 =
   // 1 + 1 = 2

   Int left_link_count = ((current_page - 1) > (window / 2))
      ? (window / 2 - 1) : (current_page - 1);
   Int pageNo = current_page - left_link_count;

   if (pageNo > 1) {    // show first page and if there are more
                           // links on the left
      result += "1 .. ";
      result += "«";
   }

   for (int i = 0; i < window-1; i++) {
      if (pageNo > pages) {
         break;
      }
      else if (pageNo == current_page) {
         result += "" + pageNo + "";
      }
      else {
         result += "pageNo";
      }
      pageNo++;
   }    // end for

   if ((pageNo - 1) < pages) {
      result += "»";
   }

   result += "
Showing"+((start  > total)?total+1:start+1)+
             " - "+(((start + 50)>total)?total:(start + 50))+"
             of Total:"+total;

   return result;

}