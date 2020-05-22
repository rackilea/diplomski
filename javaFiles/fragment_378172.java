#!/usr/bin/perl
use warnings;
use strict;

use Digest::SHA 'sha256';

my @salt = (84, 65, -51, 83, -4, -17, -32, 61, -26, 33, -106, -81,
            -14, 70, -30, 59, 41, -19, -1, 19, -104, -100, -31, 31,
            57, -6, -115, -99, 0, 38, -123, -11);

my @password = (100, 112, 107, 57, 52, 110, 50);

my $alg = 256;
my $sha = Digest::SHA->new($alg);

$sha->add(pack 'c*', @salt);
$sha->add(pack 'c*', @password);

$sha->add($sha->digest) for 1 .. 999;

my $output = $sha->hexdigest;
print "\nHash: $output\n";