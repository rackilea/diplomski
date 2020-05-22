import groovy.util.NodeBuilder
import groovy.util.Node

def root = new NodeBuilder().root {
    message 'world'
    message 'hello'

    'John' {
        'Work' {
            message 'TPS report'
        }

        'Secret Stuff' {
            message 'plea to mistress'
            message 'rejection from ex mistress'
        }
    }    

   'Jane' {
       message 'John, I know about her!'
   }
}