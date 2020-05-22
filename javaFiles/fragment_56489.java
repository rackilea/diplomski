public class AvalDate {
  private HashMap<String, AvailableTimeSlot> availableDates;
}

public class AvailableTimeSlot {
  private String from;
  private String to;
  private ArrayList<ExceptTimeSlots> except;
}

public class ExceptTimeSlots {
  private String from;
  private String to;
}