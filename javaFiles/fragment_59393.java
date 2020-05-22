$_POST['items'] = ["pencil","pen","watch"];
$_POST['qty'] = [2,3,4];
$_POST['price'] = [20,30,40];

for($i = 0; $i < count($_POST['items']); $i ++) {
    echo $_POST['items'][$i], " ", $_POST['qty'][$i], " ", $_POST['price'][$i], PHP_EOL;
}