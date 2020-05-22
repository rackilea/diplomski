my $file = "<The path of the file>";

my $length = (stat($file)) [10];
print "Content-type: application/binary\n";
print "Content-length: $length \n\n";

open FH,"$file";
binmode STDOUT;
while(<FH>){
    print
}
close FH;