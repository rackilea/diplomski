internal fun Char.remapCodepointIfProblematic(): Int {
    val i = toInt()
    return when (Platform.get()) {
        /*  https://en.wikipedia.org/wiki/Windows-1252#Character_set
         *  manually remap the difference from  ISO-8859-1 */
        Platform.WINDOWS -> when (i) {
            // 8_128
            0x20AC -> 128 // €
            0x201A -> 130 // ‚
            0x0192 -> 131 // ƒ
            0x201E -> 132 // „
            0x2026 -> 133 // …
            0x2020 -> 134 // †
            0x2021 -> 135 // ‡
            0x02C6 -> 136 // ˆ
            0x2030 -> 137 // ‰
            0x0160 -> 138 // Š
            0x2039 -> 139 // ‹
            0x0152 -> 140 // Œ
            0x017D -> 142 // Ž
            // 9_144
            0x2018 -> 145 // ‘
            0x2019 -> 146 // ’
            0x201C -> 147 // “
            0x201D -> 148 // ”
            0x2022 -> 149 // •
            0x2013 -> 150 // –
            0x2014 -> 151 // —
            0x02DC -> 152 // ˜
            0x2122 -> 153 // ™
            0x0161 -> 154 // š
            0x203A -> 155 // ›
            0x0153 -> 156 // œ
            0x017E -> 158 // ž
            0x0178 -> 159 // Ÿ
            else -> i
        }
        else -> i // TODO
    }
}