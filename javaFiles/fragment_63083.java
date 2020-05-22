package Device::ActLikeA;
use Moose::Role;

has 'attribute' => (
    isa => string,
    is  => 'rw',
    default => 'Apple',
);

sub an_a_like_method {
    my $self = shift;

    # foo
}

1;