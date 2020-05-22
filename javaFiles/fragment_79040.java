private final Map<Key, Value> map = ?* thread safe map */
private volatile Map<Key, Value> mapCopy = emptyMap();

// when you write
get lock
modify map
take a copy and store it in mapCopy
release lock

// when you read
Map<Key, Value> map = this.mapCopy;
use map