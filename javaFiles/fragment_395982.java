my $remote = IO::Socket::INET->new(
  Proto => 'tcp',
  PeerAddr => 'localhost',
  PeerPort => '10421'
) or die "Cannot connect to server: $@\n";

my $msg = "CLIENTTYPE|JDSC#0.5.9#0.2";

sendmsg $remote, $msg;

my $buf = readmsg $remote;
print "[$buf]\n";