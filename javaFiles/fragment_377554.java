ARGS=()
for A in "$@"; do
    # Modify A then add it to args. 
    # A=${A//something/something} ## Just an example.
    ARGS+=("$A")
done

# Then call java:

java com.myserver.Program "${ARGS[@]}"