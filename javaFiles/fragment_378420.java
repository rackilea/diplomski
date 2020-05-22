package main

import (
    "fmt"
    "sync"
    "time"
)

func main() {
    le := 1000

    // We want to wait until the operations finish
    var wg sync.WaitGroup

    // We "prealloc" err, since we do not want le * allocations
    var err error


    start := time.Now()
    for i := 0; i < le; i++ {

        // Add an operation to wait for to the group
        wg.Add(1)
        go func() {
            // Ensure the WaitGroup is notified we are done (bar a panic)
            defer wg.Done()

            // Short notation, since we are not interested in the result set
            if _,err = ioutil.ReadFile(fileName);err!=nil{
             fmt.Println("read file error")
            }

        }()

    }

    // Wait until all operations are finished.
    wg.Wait()
    fmt.Printf("%d iterations took %s", le, time.Since(start))
}