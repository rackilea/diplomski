<?php
$Class1 = 'a';
$Class2 = 'b';

print_r(gradient($Class1, $Class2, 10));

function gradient($class1, $class2, $size){
    $result = array();

    for($i=0; $i<$size; $i++){
        $result[$i] = rand(0, 99) >= $i/$size*100 ? $class1 : $class2;
    }

    return $result;
}
?>