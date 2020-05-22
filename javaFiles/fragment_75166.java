task makeWarTask(type: War) {
  webInf{
      from('build/resources/slave') {
          include 'base.xml'
          into('classes/')
      }
      from('build/classes/java/slave/com/test/util') {
          include 'DBConstant.class'
          into('classes/com/test/util/')
      }
  }
}