package main

import "fmt"

import "C"

//export Add
func Add(x, y int) int {
    fmt.Printf("Go says: adding %v and %v\n", x, y)
    return x + y
}