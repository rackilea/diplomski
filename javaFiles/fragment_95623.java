$reply = '';
while(true) {
    $chunk = @socket_read($sock, 10000);

    if (strlen($chunk) == 0) {
        // no more data
        break;
    }

    $reply .= $chunk;
}

echo $reply;