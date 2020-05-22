object PressureToHead {
    fun Amount<Pressure>.to(unit: Unit<PressureHead>,
            fluidDensity: Amount<VolumetricDensity>): Amount<PressureHead> {
        return Amount.valueOf(doubleValue(PASCAL)
                / (fluidDensity.doubleValue(KG_M3)
                * SensorManager.GRAVITY_EARTH), M_H2O).to(unit)
    }

    fun Amount<Pressure>.doubleValue(unit: Unit<PressureHead>,
            fluidDensity: Amount<VolumetricDensity>): Double {
        return to(unit, fluidDensity).estimatedValue
    }
}

object HeadToPressure {
    fun Amount<PressureHead>.to(unit: Unit<Pressure>,
            fluidDensity: Amount<VolumetricDensity>): Amount<Pressure> {
        return Amount.valueOf(fluidDensity.doubleValue(KG_M3)
                * SensorManager.GRAVITY_EARTH
                * doubleValue(M_H2O), PASCAL).to(unit)
    }

    fun Amount<PressureHead>.doubleValue(unit: Unit<Pressure>,
            fluidDensity: Amount<VolumetricDensity>): Double {
        return to(unit, fluidDensity).estimatedValue
    }
}