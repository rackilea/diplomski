textpop-up
$re = "/\\s+/"; 
$str = "[[StandardsEnterprise GXS Enterprise]]"; 
$subst = '|'; 

$result = preg_replace($re, $subst, $str, 1);