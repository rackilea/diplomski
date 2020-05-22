if (array_key_exists($f - $k, $T[$e])) {
    $c = 1 + max($T[$e-1][$k-1], $T[$e][$f-$k]);
}
else {
    $c = 1 + $T[$e-1][$k-1];
}