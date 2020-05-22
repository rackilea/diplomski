public String isHigherGeneration(CPU cpu) {
    if (generation > cpu.generation) {
        return "YES";
    } else {
        return "NO";
    }
}