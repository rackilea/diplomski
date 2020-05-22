$checkmethod = $_SERVER['REQUEST_METHOD'];
$var = file_get_contents("php://input");
$string = json_decode($var, TRUE);
$method = $string['method'];
$name = $string['name'];
$email = $string['email'];
$mobileno = $string['mobileno'];