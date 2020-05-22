use 5.010;
use strict;
use warnings;

use autodie;

use IO::Handle '_IOLBF';

open my $handle, '<:utf8', 'foo';

my $buffer;
$handle->setvbuf($buffer, _IOLBF, 0x10000);

while ( my $line = <$handle> ) {
    ...
}