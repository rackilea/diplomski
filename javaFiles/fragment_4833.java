float intensity = max(gl_FragColor.r, max(gl_FragColor.g, gl_FragColor.b));
float factor;
if (intensity > 0.8)
    factor = 1.0;
else if (intensity > 0.5)
    factor = 0.8;
else if (intensity > 0.25)
    factor = 0.3;
else
    factor = 0.1;