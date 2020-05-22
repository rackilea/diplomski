$choice = "Tuesday";

$Date = new DateTime();
$Clone = clone $Date;

$Clone->modify($choice." this week");

if( $Date > $Clone ){
    $Clone = clone $Date;
    $Clone->modify($choice." next week");
}

print_r($Clone->format('Y-m-d'));