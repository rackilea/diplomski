$resp = mysql_query("SELECT t.* FROM transportes t 
    JOIN user_trans ut ON t.id_transporte=ut.id_transporte 
    WHERE ut.id_usuario='$id_usuario' 
    ORDER BY fecha_reporte DESC");

if(!$resp) {
    // handle the error!
    die(mysql_error())
}

$output = [];
while( $row = mysql_fetch_assoc($resp) ) {
    $output[] = $row;
}

print_r(json_encode($output));