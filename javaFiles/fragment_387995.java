try {
          DateFormat gmtFormat = new SimpleDateFormat();
          TimeZone estTime = TimeZone.getTimeZone("EST");
          gmtFormat.setTimeZone(estTime);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
          sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
          System.out.println("EST Time: " + gmtFormat.format(sdf.parse("20140508063630")));
        } catch (ParseException e) {
          e.printStackTrace();
        }