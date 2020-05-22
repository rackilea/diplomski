ini_set('display_errors', 'On');
require("Password.php");

try{

    $mysqli = new mysqli( "localhost", "id2147309_javaprojekt123", "javaprojekt321", "id2147309_javaprojekt" );

    if( $mysqli->connect_errno ){
        echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
    }

    if( isset( $_POST["name"], $_POST["surname"], $_POST["login"], $_POST["password"], $_POST["groupNumber"], $_POST["indexNumber"] ) ){
        $name = $_POST["name"];
        $surname= $_POST["surname"];
        $login = $_POST["login"];
        $password = $_POST["password"];
        $groupNumber = $_POST["groupNumber"];
        $indexNumber = $_POST["indexNumber"];
    }


    function registerUser(){
        global $mysqli, $name, $surname, $login, $password, $groupNumber, $indexNumber;
        $passwordHash = password_hash($password, PASSWORD_DEFAULT);

        $stmt = $mysqli->prepare("INSERT INTO `user` ( `name`, `surname`, `login`, `password`, `groupNumber`, `indexNumber` ) VALUES (?, ?, ?, ?, ?, ?)");

        if( $stmt ){
            $stmt->bind_param( "ssssss", $name, $surname, $login, $passwordHash, $groupNumber, $indexNumber );
            $stmt->execute();
            $stmt->close();
            return true;
        } else {
            throw new Exception( 'Failed to prepare sql query in: ' . __FUNCTION__ );
        }
        return false;
    }
    function usernameAvailable(){
        global $mysqli, $login, $count;
        $sql = 'SELECT * FROM `users` WHERE `login` = ?';
        $stmt=$mysqli->prepare( $sql );

        if( $stmt ){
            $stmt->bind_param("s", $login);
            $stmt->execute();
            $stmt->store_result();
            $count = $stmt->num_rows;
            $stmt->close();
        } else {
            throw new Exception( 'Failed to prepare sql query in: ' . __FUNCTION__ );
        }
        return $count==0 ? true : false;
    }


    $available = call_user_func('usernameAvailable');
    $response = $available ? call_user_func('registerUser') : false;
    $mysqli->close();

    echo json_encode( $response );

}catch( Exception $e ){
    echo json_encode( array(
        'success'   =>  false,
        'Exception' =>  $e->getMessage()
    ));
}