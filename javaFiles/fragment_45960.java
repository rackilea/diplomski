#!/bin/bash
### mapper.sh

while read code; do
   evm --debug --code $code run
done