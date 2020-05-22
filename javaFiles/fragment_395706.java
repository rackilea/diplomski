import groovy.swing.SwingBuilder

def mainMenu = { builder ->
  builder.panel( id:'mainM' ) {
    label( text: 'Welcome Travelers' )
    button( text: 'Say Hello', actionPerformed:{
      builder.optionPane( message:'Hello World' )
             .createDialog( null, 'Hello' )
             .show()
    } )
  }
}

new SwingBuilder().with { builder ->
  builder.edt {
    frame( size:[ 1024, 768 ], show:true ) {
      panel()
      mainMenu( builder )
    }
  }
}