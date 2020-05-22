<?php

// array for JSON response
$response = array();
//set values just in case any thing goes wrong
$response["status"] = 0;
$response["message"] = "Error before start";

// check for post data with isset
if (isset($_POST["Title"])) {

    $title = $_POST["Title"];

    // You were not using PDO so I dumped your connection and require you to provide...
    //...a configuration file for ...
    require_once __DIR__ . '/db_config.php';
    // ...these  variables
    $host = DB_SERVER;
    $db   = DB_DATABASE;
    $user = DB_USER;
    $pass = DB_PASSWORD;
    $charset = 'utf8';

    $dsn = "mysql:host=$host;dbname=$db;charset=$charset";
    $opt = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];

    try{
        // connecting to db with PDO
        $pdo = new PDO($dsn, $user, $pass, $opt);


        $sql = 'SELECT isbn, title, authors, accession, publisher, pubyear, pages, rak, hr, vr, barcode
                FROM books 
                WHERE title LIKE :titleParam';

        $titleParam = "%".$title."%";

        $stmt = $pdo->prepare($sql);

        // Bind the parameter
        $stmt->bindParam(':titleParam', $titleParam, PDO::PARAM_STR);

        $res = $stmt->execute();

        if ($res) {
            // success
            $response["status"] = 1;
            // connection node
            $response["books"] = array();

            while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
                $data = array();
                $data["isbn"] = $row["isbn"];
                $data["title"] = $row["title"];
                $data["authors"] = $row["authors"];
                $data["accession"] = $row["accession"];
                $data["publisher"] = $row["publisher"];
                $data["pubyear"] = $row["pubyear"];
                $data["pages"] = $row["pages"];
                $data["rak"] = $row["rak"];
                $data["hr"] = $row["hr"];
                $data["vr"] = $row["vr"];
                $data["barcode"] = $row["barcode"];

                array_push($response["books"], $data);
            }
        }
        else {
            // required field is missing
            $response["status"] = 2;
            $response["message"] = "No data returned";
        }   
    }
    catch (Exception $e){
        $response["status"] = 3;
        $response["message"] = "Error occurred." . $e->getMessage();
    }
}
else {
    $response["status"] = 4;
    $response["message"] = "Post parameters are not correct";
}
// echoing JSON response
echo json_encode($response);
?>