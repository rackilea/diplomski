object HeadToLength {
    fun Amount<PressureHead>.toLength(unit: Unit<Length>): Amount<Length> {
        return Amount.valueOf(doubleValue(M_H2O), METER).to(unit)
    }

    fun Amount<PressureHead>.doubleValueLength(unit: Unit<Length>): Double {
        return toLength(unit).estimatedValue
    }
}

object LengthToHead {
    fun Amount<Length>.toHead(unit: Unit<PressureHead>): Amount<PressureHead> {
        return Amount.valueOf(doubleValue(METER), M_H2O).to(unit)
    }

    fun Amount<Length>.doubleValueHead(unit: Unit<PressureHead>): Double {
        return toHead(unit).estimatedValue
    }
}