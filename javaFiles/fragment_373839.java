public Container(Calendar start, Calendar end)
  {

    this.start = (Calendar) start.clone();
    this.end = (Calendar) end.clone();
  }