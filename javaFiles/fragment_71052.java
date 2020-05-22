while ($filename = shift) {
    open my $in, "<$filename";
    my $loc = 0;
    my $log = "NO LOGGER";
    while (<$in>) {
        $loc++;
        if (m/import org.slf4j.LoggerFactory/) {
            $log = "has logger";
        }
    }
    print "$filename : $loc LOC $log\n";
    $total{$log} += $loc;
}
print "\n\nTOTAL LOGGED: $total{'has logger'}\nTOTAL UNLOGGED: $total{'NO LOGGER'}\n";