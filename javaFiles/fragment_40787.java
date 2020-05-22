@XStreamAlias("message")
class RendezvousMessage {

  @XStreamOmitField
  private int messageType;

  @XStreamImplicit(itemFieldName="part")
  private List<String> content;

  @XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
  private boolean important;

  @XStreamConverter(SingleValueCalendarConverter.class)
  private Calendar created = new GregorianCalendar();

  public RendezvousMessage(int messageType, boolean important, String... content) {
    this.messageType = messageType;
    this.important = important;
    this.content = Arrays.asList(content);
  }
}