# Starts Alfred in a background process with pipes in and out of it
coproc java Alfred
# Alfred's stdin is now referred to with ${COPROC[1]}
echo Hey what time is it?\r >&${COPROC[1]}
echo When is my next meeting?\r >&${COPROC[1]}
# Alfred's stdout is found with ${COPROC[0]}
cat <&${COPROC[0]}