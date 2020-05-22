#!/usr/bin/perl -w
my $passstring = "This string \xEF\xBF\xBD == � is valid UTF-8";
my $failstring = "This string \x{FFFD} == � is not valid UTF-8";
if ($passstring =~ /^([\x00-\x7F]|[\xC2-\xDF][\x80-\xBF]|\xE0[\xA0-\xBF][\x80-\xBF]|[\xE1-\xEC][\x80-\xBF]{2}|\xED[\x80-\x9F][\x80-\xBF]|[\xEE-\xEF][\x80-\xBF]{2}|\xF0[\x90-\xBF][\x80-\xBF]{2}|[\xF1-\xF3][\x80-\xBF]{3}|\xF4[\x80-\x8F][\x80-\xBF]{2})*$/)
    {
    print 'Passstring passed'."\n";
    }
else
    {
    print 'Passstring did not pass'."\n";
    }
if ($failstring =~ /^([\x00-\x7F]|[\xC2-\xDF][\x80-\xBF]|\xE0[\xA0-\xBF][\x80-\xBF]|[\xE1-\xEC][\x80-\xBF]{2}|\xED[\x80-\x9F][\x80-\xBF]|[\xEE-\xEF][\x80-\xBF]{2}|\xF0[\x90-\xBF][\x80-\xBF]{2}|[\xF1-\xF3][\x80-\xBF]{3}|\xF4[\x80-\x8F][\x80-\xBF]{2})*$/)
    {
    print 'Failstring passed'."\n";
    }
else
    {
    print 'Failstring did not pass'."\n";
    }
exit;