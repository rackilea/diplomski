public class DateTypeCoverter {

  @TypeConverter
  public Long convertDateToLong(Date date){
    return date.getTime(); //<-- provoking your NPE
    //recommend
    //return date == null ? null : date.getTime()
  }

  @TypeConverter
  public Date convertLongToDate(long time){//<-- change long to Long
    return new Date(time);
    //recommend
    //return time == null? null : new Date(time)
  }
}