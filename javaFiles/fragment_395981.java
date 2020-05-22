sub sendmsg {
  my($s,$msg) = @_;

  die "message too long" if length($msg) > 0xffff;

  my $sent = $s->send(
    pack(n => (length($msg) & 0xffff)) .
    $msg
  );

  die "send: $!"    unless defined $sent;
  die "short write" unless $sent == length($msg) + 2;
}

sub readmsg {
  my($s) = @_;
  my $buf;
  my $nread;

  $nread = $s->read($buf, 2);
  die "read: $!"   unless defined $nread;
  die "short read" unless $nread == 2;

  my $len = unpack n => $buf;

  $nread = $s->read($buf, $len);
  die "read: $!"   unless defined $nread;
  die "short read" unless $nread == $len;

  $buf;
}