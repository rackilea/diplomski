pacman
  : section1=section section2=section map section3=section
  {
    processFirstSection($section1);
    if(checkSecondSection($section2))
    {
      handleThirdSection($section3);
    }
  }