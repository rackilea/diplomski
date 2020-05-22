declare function local:generate($names as xs:string*) as element(*) {
   if (exists($names)) then
      element{head($names)}{local:generate(tail($names)}
   else ()
};
local:generate(tokenize("/root/child/grandson", "/")[.]);