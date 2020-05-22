#!/usr/bin/env perl    

use strict;
use warnings;
use 5.010;

my %weight = (
  foo   => 5,
  bar   => 4,
  snafu => 3,
  blam  => 2,
  bingo => 1,
);

my $picks = 3;

while ($picks && %weight) {
  my $total_weight;
  $total_weight += $_ for values %weight;

  my $remaining_weight = rand($total_weight);
  for my $item (keys %weight) {
    if ($remaining_weight < $weight{$item}) {
      say $item;
      $picks--;
      delete $weight{$item};
      last;
    }
    $remaining_weight -= $weight{$item};
  }
}