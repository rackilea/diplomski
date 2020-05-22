#!/bin/sh

# Run the test suite.
# It will exit with 0 if it everything compiled and tested fine.
ant test
if [ $? -eq 0 ]; then
  exit 0
else
  echo "Building your project or running the tests failed."
  echo "Aborting the commit. Run with --no-verify to ignore."
  exit 1
fi