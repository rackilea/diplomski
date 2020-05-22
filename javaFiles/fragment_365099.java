import java.text.SimpleDateFormat

SimpleDateFormat sdf = new SimpleDateFormat('MM/dd/yy')
SimpleDateFormat fmt = new SimpleDateFormat('yyyy-MM-dd')

Calendar cal = Calendar.getInstance()
cal.add(Calendar.YEAR, -100)
sdf.set2DigitYearStart(cal.getTime())

dates = ['01/01/01', '10/30/08','01/01/09']
dates.each {String d ->
  println fmt.format(sdf.parse(d))
}