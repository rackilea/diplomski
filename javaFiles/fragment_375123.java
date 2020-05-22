N-1
X_real[k] = SUM { x_real[n] * cos(2*pi*n*k/N) + x_imag[n] * sin(2*pi*n*k/N) }
            n=0

            N-1
X_imag[k] = SUM { x_imag[n] * cos(2*pi*n*k/N) - x_real[n] * sin(2*pi*n*k/N) }
            n=0