//...
$var = "a";
if(isset($_POST['name'])){
    $var = $_POST['name'];
} 

$query = "SELECT * FROM TestTable WHERE name = '$var'";