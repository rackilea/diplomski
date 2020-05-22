final Configuration configuration = chart.getConfiguration();  // As per usual, interact with the chart via its Configuration object.
Title t = configuration.getTitle();  // Obtain the object representing the title (or Subtitle for subtitle).
if ( t.getStyle() == null ) {  // If not yet existing…
    t.setStyle( new Style() );  // Instantiate a Style object and install on the Title object.
}
Style st = t.getStyle();  // Obtain the Style object (whether new or pre-existing).
st.setFontSize( "0.5em" );  // Half an em is teeny-tiny, but demonstrates this approach works to change the font size.