public class BoyGirl {
  private long id;
  private Boy boy;
  private Girl girl;
  private Date startDating;
}

public class Boy {
  //other attributes omitted
  private Set<BoyGirl> boyGirls;
}

public class Girl {
  //other attributes omitted
  private Set<BoyGirl> boyGirls;
}