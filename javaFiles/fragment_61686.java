declare variable $pfn external;                          
declare variable $cap external;                          
declare variable $rate external;              
for $p in doc('CapabilitiesDefn.xml')//Site/Function  
for $c in $p/Capability                                  
let $r1 := $c/Rate/min                                   
let $r2 := $c/Rate/max                                   
 where $p/@name=$pfn                                     
   and $c/@name=$cap                                     
   and xs:long($rate) > xs:long($r1)
return xs:string($p/@name)