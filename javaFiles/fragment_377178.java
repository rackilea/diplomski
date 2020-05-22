$string = "weiun.fqw7pofnj89.5poopf99";
// find the length of the string
$length = strlen($string);
// loop the string
for($i=0;$i<$length;$i++){
  // find the '.'
  if($string[$i] == '.'){
    $number_before_decimal ='';
    $number_after_decimal ='';
    // backward loop until we find non numeric value
    for($j=($i-1);$j>=0;$j--){
        if((ord($string[$j])>=48) && (ord($string[$j])<=57)){
           // add values in reverse
           $number_before_decimal = $string[$j].$number_before_decimal;
        }else{
            break;
        }
    }
    // forward loop until we find non numeric value
    for($k=$i;$k<$length;$k++){
        if($string[$k] == '.') continue;
        if((ord($string[$k])>=48) && (ord($string[$k])<=57)){
             $number_after_decimal .= $string[$k];
        }else{
            break;
        }
    }
    if(($number_before_decimal!='') && ($number_after_decimal!='')){
        echo $number_before_decimal.'.'.$number_after_decimal;
        echo "<br/>";
    }
  }
}