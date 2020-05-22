#!/usr/bin/perl

use strict; use warnings;

my $tmpl = <<EO_XML;
<vehicles ID="%s">
    <vehicle>
        <make>Toyota</make>
        <model>Yaris</model>
        <year>2009</year>
    </vehicle>
    <vehicle>
        <make>Ford</make>
        <model>Taurus</model>
        <year>2008</year>
    </vehicle>
</vehicles>
EO_XML

my $generator = make_id_generator('A' .. 'Z', 0 .. 9);

printf $tmpl, $generator->() for 1 .. 10;

sub make_id_generator {
    my @chars = @_;
    return sub {
        join '', @chars[ map { rand @chars } 1 .. 8 ];
    }
}