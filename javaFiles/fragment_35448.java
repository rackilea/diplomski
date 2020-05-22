private void comparePlayerStatsBtnActionPerformed(java.awt.event.ActionEvent evt)
{                                                      

    /*
     * Include below information in a loop to generate chart, based on option selected.
     */
    CountryVsCountryChart chart = new CountryVsCountryChart("Test Chart", "A Test Chart", players, 1);
    /**/

    graphDisplayPanel.add(chart);
    repaint();

}