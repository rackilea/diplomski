@Test
   public void testOrder5() throws Exception {
      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
      Phone input = new DefaultPhone();
      Date date = new Date();
      input.setCreatedDate(date); // passing in date object
      PhoneObj output = Book.change(input); //pases input to change method to convert date to phone object
      assertThat(sf.format((Date)(output.getCreatedDate())), sf.format(date));
   }