$getAllFreebies = $db->getFreebies(...);
$data = array();
while($row = mysql_fetch_assoc($getAllFreebies)) {
   $data[] = array(
      .... your variable assignments here ...
   );
}
echo json_encod($data);