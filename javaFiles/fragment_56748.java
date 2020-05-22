class Java {
  private static volatile Java instance
  private Java() {}
  static Java getInstance () {
    if( instance ) {
      instance
    } else {
      synchronized( Java ) {
        if( instance ) {
          instance
        } else {
          instance = new Java()
        }
      }
    }
  }
}