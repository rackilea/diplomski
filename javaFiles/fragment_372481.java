String query = ......<rest of query>
     query = query.concat(" where `consumer`.`email` = ? );
    ......<rest of query>

    $db = new mysqli('localhost', 'username', 'password', 'database');
    // Create statement object
    $stmt = $db->stmt_init();


// Create a prepared statement
if($stmt->prepare(query )) {
    $stmt->bind_param('s', $email_id);

    // Set your variable    
    $email_id= "example@exp.com";

    // Execute query
    $stmt->execute();
}