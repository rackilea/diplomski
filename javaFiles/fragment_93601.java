index.x = (int) ((ndc.x/2.0f + 0.5f) * boardSize.x)
index.y = (int) ((ndc.y/2.0f + 0.5f) * boardSize.y)
if (index.x == boardSize.x) // in case ndc.x was exactly 1
    --index.x;
if (index.y == boardSize.y) // in case ndc.y was exactly 1
    --index.y;