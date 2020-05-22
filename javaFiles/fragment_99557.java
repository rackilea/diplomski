# M is an adjacency matrix; we assume that it is square.
# The function returns the translation vector
def renumber(M):
  ones = 0
  zeros = len(M) - 1
  trans = []
  for row in M:
    if any(row):
      # the edge is connected
      trans.append(ones)
      ones += 1
    else:
      # the edge is unconnected
      zeros -= 1
      trans.append(zeros)
  return trans