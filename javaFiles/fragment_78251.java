double sample;
    if (distribution instanceof RealDistribution) {
        sample = ((RealDistribution) distribution).sample()[i];
    } else {
        // The int sample value is converted to a double in the assignment.
        sample = ((IntegerDistribution) distribution).sample()[i];
    }