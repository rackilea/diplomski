Phase: Meaurements
Input: Token Number 
Options: control=appelt debug=true



Rule: Height
(
({Number})
( {Token.string=~"[Ff]t"} | {Token.string=~"[Ii]n"} | {Token.string=~"[Cc]m"})
):height
-->
:height.Height= {value= :height.Number.value, unit= :height.Token.string}