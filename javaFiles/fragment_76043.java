@Test
public void tesTakeUntil() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Observable.from(numbers)
              .takeUntil(number -> number > 3)
              .subscribe(System.out::println);

}