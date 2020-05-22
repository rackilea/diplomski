<identifier> ::=
          [ <introducer><character set specification> ] <actual identifier>

     <actual identifier> ::=
            <regular identifier>
          | <delimited identifier>

     <SQL language identifier> ::=
          <SQL language identifier start>
            [ { <underscore> | <SQL language identifier part> }... ]

     <SQL language identifier start> ::= <simple Latin letter>

     <SQL language identifier part> ::=
            <simple Latin letter>
          | <digit>