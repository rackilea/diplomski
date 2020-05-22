queue = [ rootDir ]
stack = []

while ( !queue.isEmpty() ) {
    currentDir = queue.take()
    stack.push( currentDir )
    files = currentDir.list()
    for ( f : files ) {
        if ( f.isDirectory() ) {
            queue.add( f )
        } else {
            f.delete()
        }
    }
}

while ( !stack.isEmpty() ) {
    f = stack.pop()
    f.delete()
}