public class A {


    int common;

    @Strategy3Exclude
    @Strategy2Exclude
    int forGSON1;

    @Strategy3Exclude
    @Strategy1Exclude
    int forGSON2;


    @Strategy2Exclude
    @Strategy1Exclude
    int forGSON3;

    @Strategy3Exclude
    int forGSON12;
    ...
    getters and setters
}