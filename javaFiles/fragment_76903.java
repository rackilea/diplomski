int* logSumArray = (int*)(&logSumVector);

    __m128i valuesToXor = _mm_cvtsi32_si128(expTable[*(logSumArray++)]);
    valuesToXor = _mm_insert_epi32(valuesToXor, expTable[*(logSumArray++)], 1);
    valuesToXor = _mm_insert_epi32(valuesToXor, expTable[*(logSumArray++)], 2);
    valuesToXor = _mm_insert_epi32(valuesToXor, expTable[*(logSumArray++)], 3);