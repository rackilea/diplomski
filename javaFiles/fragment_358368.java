public Fish catchAFish()
    {
    if (fishes.size() == 0) {
        throw new Exception("No fish to be found here..");
    }

    int randomNumber = (int) (Math.random() * fishes.size());
    return fishes.remove(randomNumber);
    }