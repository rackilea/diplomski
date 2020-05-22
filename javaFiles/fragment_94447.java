template<class I, class C>
void sort_indexes( I begin, I end, C const& container ) {
  using index_type = std::iterator_traits<I>::reference;
  std::sort( begin, end, [&](index_type lhs, index_type rhs) {
    return container[lhs]<container[rhs];
  };
}