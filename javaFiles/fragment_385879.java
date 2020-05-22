public static Comparator<VO> sortData = new Comparator<VO>()
{
     public int compare(VO vo1, VO vo2) {
         if (vo1.getName().equals("LAST ITEM")) {
              if (vo2.getName().equals("LAST ITEM")) {
                  return 0;
              } else {
                  return 1;
              }
         else if (vo2.getName().equals("LAST ITEM")) {
              return -1;
         }
         return (vo1.getName()).compareTo(vo2.getName());
     }
};