class MyArray {
   private $my_array;

   function  __construct() {
      $this->my_array = array();
   }

   public function setMyArray($value) {
      $this->my_array = $value;
   }

   public function getMyArray() {
      return $this->my_array;
   }

   public function getLastElement() {
      $last_elem = array_reverse($this->getMyArray());
      return $last_elem[0];
   }
}

$myArr = new MyArray();
$a[] = "Hello"; // use this instead of array_push
$a[] = "World";
$myArr->setMyArray($a);
echo "My Array:<pre>".print_r($myArr->getMyArray(),true)."</pre><br />\n";
echo "Last Element: ".$myArr->getLastElement()."<br />\n";

$a[] = "Yet another element";
$myArr->setMyArray($a);
echo "My Array Again:<pre>".print_r($myArr->getMyArray(),true)."</pre><br />\n";
echo "Last Element Again: ".$myArr->getLastElement()."<br />\n";