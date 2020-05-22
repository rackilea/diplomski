Map<String,Double> currencies = new HashMap<String,Double>();
    Pattern pattern = Pattern.compile("<Rate currency=\"([^\"]{3})\">(.+?)</Rate>");
    Matcher matcher = pattern.matcher(data);
    int pos = 0;
    while(matcher.find(pos)) {
      System.out.println("Found: " + matcher.group(1) + ": " + Double.valueOf(matcher.group(2)));
      currencies.put(matcher.group(1), Double.valueOf(matcher.group(2)));
      pos = matcher.end();
    }

    Scanner keyboard = new Scanner(System.in);

    boolean ok = true;
    while(ok) {
      System.out.println("What currency rate do you need? (QUIT to quit)");
      String cur = keyboard.nextLine();
      System.out.println("Rate for " + cur + " is " + currencies.get(cur));
      if("QUIT".equalsIgnoreCase(cur)) {
        ok = false;
      }
    }    
    keyboard.close();