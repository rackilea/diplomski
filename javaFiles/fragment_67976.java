task runAllTestsByGroups << {
      ant.parallel(threadsPerProcessor: 1) {
                    ant.junit (...) {
            // run test group 1
            ...
        }
          ant.junit(...) {
            // run test group 2
            ...
       }
         // run group 3, 4, 5 ...
    }
  }