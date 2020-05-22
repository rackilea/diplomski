@Test
@Transactional
@Rollback(false)
public void testDeleteCoffeeType() {

    CoffeeType coffeeType = coffeeTypeDao.findCoffeeType(4L);
    final String caffeForte = coffeeType.getName();

    coffeeTypeDao.deleteCoffeeType(coffeeType);
    entityManager.flush();

    int rowsFoundWithCaffeForte = jdbcTemplate
        .queryForInt("SELECT COUNT(*) FROM COFFEE_TYPES where NAME = ?", 
            caffeForte);
    assertEquals(0, rowsFoundWithCaffeForte);
}