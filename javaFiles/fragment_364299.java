#! /usr/bin/perl -i.bak    
use warnings;
use strict;
my $template =
  '^( public
      String
      Get)(\w+)( \( \) { return
        m_ParsedValue . get \( m_Tags . get \( )(\d+)( \) \) ; } )$';
$template =~ s/ +/\\s*/g;
$template =~ s/(\r?\n)+/\\s+/g;
my $getter = qr/$template/x;

die "Usage: $0 after new-name source ..\n" unless @ARGV >= 3;
my $after = shift;
my $add   = shift;
my $index;
while (<>) {
  unless (/$getter/) {
    print;
    next;
  }
  my($abc,$name,$lmno,$i,$xyz) = ($1,$2,$3,$4,$5);
  if (defined $index) {
    print join "" => $abc, $name, $lmno, ++$index, $xyz;
  }
  else {
    if ($name eq $after) {
      $index = $i;
      print; print join "" => $abc, $add, $lmno, ++$index, $xyz;
    }
    else { print; }
  }
}