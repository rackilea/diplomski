use CGI qw(param header);
use JSON;

my $var = param('var');

my $json = &fetch_return_data($var);

print header('application/json');

print to_json($json); # or encode_json($json) for utf-8