TValue GetValueOrDefault<TKey, TValue>(Dictionary<TKey, TValue> dictionary, TKey key)
{
    TValue value;
    dictionary.TryGetValue(key, out value);
    return value;
}