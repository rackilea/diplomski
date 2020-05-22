include('includes/json.php');

$json = new json();

$json->add('status', '403');
$json->add('message', 'YOU ARE FORBIDDEN!');

$json->send();