Y' = int [(MJD - 15078.2) / 365.25]
M' = int { [MJD - 14956.1 - int (Y' * 365.25) ] / 30.6001 }
D = MJD - 14956 - int (Y' * 365.25) - int (M' * 30.6001 )

If M' = 14 or M' = 15, then K = 1; else K = 0

Y = Y' + K

M = M' - 1 - K * 12