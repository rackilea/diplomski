public class Film implements Comparable<Film>{
  int finalScore ;

  public Film(int finalScore){
      this.finalScore = finalScore;
  }

  public int getFinalScore(){
      return this.finalScore;
  }

  @Override
  public int compareTo(Film film2) {
      return Double.compare(this.finalScore, film2.finalScore);
  }
}