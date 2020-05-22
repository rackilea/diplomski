package org.example;

@Service
public class SomeBusinessService {
    @OracleFailover
    void doSomethingWithOracle(){
        // body goes here
    }
}