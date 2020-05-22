$inputValues = range(1,3); //here you set your input(2 or 3 or what you want)

$result = array();

function variations($inputValues, $level, &$result, $current = array()) {
    for($i = 0; $i < count($inputValues); $i++) {
        $new = array_merge($current, array($inputValues[$i]));
        if($level == 1) {
          sort($new);
            if (!in_array($new, $result)) {
                $result[] = $new;          
            }
        } else {
            variations($inputValues, $level - 1, $result, $new);
        }
    }
}
for ($i = 0; $i<count($inputValues); $i++) {
    variations($inputValues, $i+1, $result);
    }

foreach ($result as $arr) {
    echo '('.join(",", $arr) . ')';
}