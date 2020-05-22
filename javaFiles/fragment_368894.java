Random r = new Random();
int result = r.nextInt(5);



driver.findElement(By.xpath("//android.widget.FrameLayout[@index='"+result+"']/android.widget.ImageView[@index='0']")).click();