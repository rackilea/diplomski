$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, TRUE);
$nameArray = array($input['names']);
$phoneNumArray = array($input['phoneNums']);
for($i=0;i<count($nameArray);$i++){
    $data = array(
        'name' => $nameArray[$i],
        'phone' => $phoneNumArray[$i],
    );
    $this->saveData('phonebook', $data);
}