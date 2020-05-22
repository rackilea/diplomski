if (specIntensity > 0.6)
    specFactor = 1.0;
else if (specIntensity > 0.3)
    specFactor = 0.5;
else
    specFactor = 0.1;

specular *= specFactor;