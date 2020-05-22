use Unicode::Collate;
sub compare_strs
{
    my ( $str1, $str2 ) = @_;
    # Treat vars as strings by quoting. 
    # Possibly incorrect/irrelevant approach. 
    return $Collator->cmp("$str1", "$str2");
}