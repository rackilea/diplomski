// assumes this.viewer contains your viewer, your code might be different ...
// make sure viewer has been created
if (this.viewer) {

  // I added this to handle some specific cases
  if(this.viewer.impl.selector) {

    this.viewer.tearDown()
    this.viewer.finish()
    this.viewer = null
  }
}