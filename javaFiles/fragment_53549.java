<?php
// Stderr
exec("curl --aaa 2>&1", $return1);
print_r($return1);
// Stdout
exec("echo hello", $return2);
print_r($return2);