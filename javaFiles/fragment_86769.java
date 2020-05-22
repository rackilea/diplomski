$myString = "Red,Blue,Black";// incoming string comma names
$myArray = explode(',', $myString); 
print_r($myArray);
$sql = "INSERT INTO `cat_interest`(`id`,`categories`) VALUES";
foreach($myArray as $value){
    $sql .= " (1, '{$value}'),";
}
$sql = rtrim($sql, ',');