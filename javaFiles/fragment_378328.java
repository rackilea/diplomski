/*
         * KEYSTORE FORMAT:
         *
         * Magic number (big-endian integer),
         * Version of this file format (big-endian integer),
         *
         * Count (big-endian integer),
         * followed by "count" instances of either:
         *
         *     {
         *      tag=1 (big-endian integer),
         *      alias (UTF string)
         *      timestamp
         *      encrypted private-key info according to PKCS #8
         *          (integer length followed by encoding)
         *      cert chain (integer count, then certs; for each cert,
         *          integer length followed by encoding)
         *     }
         *
         * or:
         *
         *     {
         *      tag=2 (big-endian integer)
         *      alias (UTF string)
         *      timestamp
         *      cert (integer length followed by encoding)
         *     }
         *
         * ended by a keyed SHA1 hash (bytes only) of
         *     { password + whitener + preceding body }
         */