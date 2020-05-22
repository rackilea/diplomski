//define the jam class
class jam {
    public $id;
    public $flavour;
    public $useby;
    public $openedStatus;

    public function __construct($id, $flavour, $useby, $openedStatus) {
        $this->id = $id;
        $this->flavour = $flavour;
        $this->useby = $useby;
        $this->openedStatus = $openedStatus;
    }

    public function updateOpenedStatus($newStatus) {
        $this->openedStatus = $newStatus;
    }

}

//create an array of objects with different properties
$jams[] = new jam(1, "strawberry", "december", false);
$jams[] = new jam(2, "raspberry", "november", false);

//loop the array and change the first object
foreach($jams as $jam) {
    if($jam->id == 1) {
       $jam->updateOpenedStatus(true);
    }
}

var_dump($jams);