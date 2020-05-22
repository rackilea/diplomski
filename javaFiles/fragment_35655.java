for (Double value : plane)
    value = (randomFloat() * 2 - 1.0) / Math.sqrt(maxNumSource);
            ^^^^^^^^^^^^^^^^^^^^^^^^^^^
               operator precendence :)
    ^^^^
     modifies the current 'value' in 'plane'