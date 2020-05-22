int32_t cmp_lt(int32_t lhs, int32_t rhs) {
    int64_t tmp = lhs;
    tmp -= rhs;
    tmp >>= 63;
    return tmp & 1;
}

int32_t cmp_eq(int32_t lhs, int32_t rhs) {
    return (cmp_lt(lhs, rhs) | cmp_lt(rhs, lhs)) ^ 1;
}

// 32-bit only version
int32_t cmp_lt32(int32_t lhs, int32_t rhs) {
    int32_t tmp = lhs - rhs;
    // -lhs < +rhs is always true
    tmp |= ~rhs & lhs;
    // +lhs < -rhs is always false
    tmp &= ~rhs | lhs;
    tmp >>= 31;
    return tmp & 1;
}