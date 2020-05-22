public class FighterXmlAdapter extends XmlAdapter<Fighter, Fighter> {

  @Override
  public Fighter unmarshal(final Fighter fighter) throws Exception {
    return fighter == null ? NULL_FIGHTER : fighter;
  }

  @Override
  public Fighter marshal(final Fighter fighter) throws Exception {
    return fighter.equals(NULL_FIGHTER) ? null : fighter;
  }

}