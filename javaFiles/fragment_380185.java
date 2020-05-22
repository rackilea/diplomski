irb(main):002:0> require 'English'; test = "One"+ $INPUT_RECORD_SEPARATOR
=> "One\n"
irb(main):003:0> test1 = "One" + $/
=> "One\n"
irb(main):004:0> test2 = "One"+$-0
=> "One\n"
irb(main):005:0> require 'English';test3="One"+$RS
=> "One\n"
irb(main):006:0>