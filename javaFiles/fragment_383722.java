if (md5($_SERVER['QUERY_STRING']."A_SECRET_WORD")!=$_SERVER['X-CHECKSUM']) {
    // Wrong checksum
}

$timediff=60;

if ( $_GET['timestamp']>(time()+$timediff) || $_GET['timestamp']<(time()-$timediff) ) {
    // Bad timestamp
}