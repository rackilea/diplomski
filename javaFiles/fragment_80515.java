#!/bin/bash
if java RegexTestHarness "my_regex" "my_input_string"; then
    echo "Expression matches"
else
    echo "Expression doesn't match"
fi