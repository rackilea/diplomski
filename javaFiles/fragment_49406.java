Set<String> pops=Driver.getWindowHandles();
 Iterator<String> it =pops.iterator();
  while (it.hasNext()) {
    String popupHandle=it.next().toString();
   System.out.println("Driver Now switched to Pop Up with Title- "+ Driver.switchTo().window(popupHandle).getTitle());
   }
}