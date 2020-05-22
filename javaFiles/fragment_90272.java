# To swap elements i and j
If j < k:
  # Both elements to be swapped are in the selection
  tmp = value[i]; value[i] = value[j]; value[j] = tmp
Else If j in rest:
  # Element j has been swapped before
  tmp = value[i]; value[i] = rest[j]; rest[j] = tmp
Else:
  # The value at j is still j, we now add it to the virtual array
  rest[j] = value[i]; value[i] = j