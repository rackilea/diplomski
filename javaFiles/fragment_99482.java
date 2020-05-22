<?php

$mysqli = new mysqli("localhost", "my_user", "my_password", "pinkfluf_dvonx");

/* check connection */
if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}


/* Select queries return a resultset */
if ($result = $mysqli->query("SELECT Name FROM City LIMIT 10")) {
    printf("Select returned %d rows.\n", $result->num_rows);

    /* free result set */
    $result->close();
}

/* If we have to retrieve large amount of data we use MYSQLI_USE_RESULT */
if ($result = $mysqli->query('SELECT u.id AS "Student ID", u.username AS "Student Name", ... FROM members u, grading g, assignments a WHERE ...')) {

    while($row = $result->fetch_array(MYSQLI_NUM)) {
        for ($i=0; $i<sizeof($row); $i++) {
            echo $row[$i] . ";";
        }
        echo "\n";
    }

    $result->close();
}

$mysqli->close();
?>