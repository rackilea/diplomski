topLevelStream() //create a stream of top level elements
  .flatMap( top -> top.streamMid() //create a stream of mid level elements
    .flatMap( mid -> mid.streamLow() //create a stream of low level elements
      .map(low -> "use top, mid and low here") 
    ) 
  )
  .collect( ... );