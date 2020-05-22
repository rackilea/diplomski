N = 100
TARGET_MEAN = 7.5

total = N * TARGET_MEAN
poisson = [0, total]
(N - 1).times { poisson << rand(0.0..total) }
poisson.sort!
(1...poisson.length).each { |i| p poisson[i] - poisson[i-1] }