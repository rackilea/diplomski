if(isset($_POST['name']) && isset($_POST['score'])){
    $sql = "INSERT INTO highscores(name, score) VALUES (:name, :score)";
    $data = array(":name"=>$_POST['name'], ":score"=>$_POST['score']);
    $db->run($sql, $data);
    echo display();
}
function display(){
    $sql = "SELECT name, score FROM highscores ORDER BY score DESC";
    $result = $db->run($sql, array());
    return json_encode($result);
}