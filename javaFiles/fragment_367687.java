<
 (?:
      (?:
           (?:
                # Invisible content; end tag req'd
                (                             # (1 start)
                     script
                  |  style
                  |  object
                  |  embed
                  |  applet
                  |  noframes
                  |  noscript
                  |  noembed 
                )                             # (1 end)
                (?:
                     \s+ 
                     (?>
                          " [\S\s]*? "
                       |  ' [\S\s]*? '
                       |  (?:
                               (?! /> )
                               [^>] 
                          )?
                     )+
                )?
                \s* >
           )

           [\S\s]*? </ \1 \s* 
           (?= > )
      )

   |  (?: /? [\w:]+ \s* /? )
   |  (?:
           [\w:]+ 
           \s+ 
           (?:
                " [\S\s]*? " 
             |  ' [\S\s]*? ' 
             |  [^>]? 
           )+
           \s* /?
      )
   |  \? [\S\s]*? \?
   |  (?:
           !
           (?:
                (?: DOCTYPE [\S\s]*? )
             |  (?: \[CDATA\[ [\S\s]*? \]\] )
             |  (?: -- [\S\s]*? -- )
             |  (?: ATTLIST [\S\s]*? )
             |  (?: ENTITY [\S\s]*? )
             |  (?: ELEMENT [\S\s]*? )
           )
      )
 )
 >