package Device;
use Moose;

has 'part_no' => (
  isa => 'Str',
  is  => 'ro',
  required => 1,
);

has 'serial' => {
  isa  => 'Str',
  is   => 'ro',
  lazy => 1,
  build => '_build_serial',
);

1;