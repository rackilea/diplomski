my @PART_MATCH = (
    [ qr/Foo/,              'Device::MetaSyntacticVariable' ],
    [ qr/^...-[^_]*[A][^-], 'Device::ActLikeA; ],
    [ qr/^...-[^_]*[B][^-], 'Device::ActLikeB; ],
# etc
);

my $parts = load_parts($config_file);

for my $part ( @$parts ) {

    my $part_no = $part->part_number();

    for my $_ (@PART_MATCH) {
        my ($match, $role) = @$_;
        $part->apply_role($role)
           if $part_no =~ /$match/;
    }

}