#!/bin/bash
args=(
    -H 'app_id: your_app_id'
    -H 'app_key: your_app_key'
    -F 'source=@/path/to/file'
    -F 'timeout=60'
    'http://httpbin.org/post'
)
curl "${args[@]}"