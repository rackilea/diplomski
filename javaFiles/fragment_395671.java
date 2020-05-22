String sql = "select * from persoon inner join ploeg where persoon.ploeg_id = ploeg.id";
PreparedStatement statement = connection.prepareStatement(sql);
ResultSet rs = statement.executeQuery();
List<Persoon> persoonList = new ArrayList<>();
while (rs.next()) {
    PloegBag ploeg = new PloegBag();
    // populate ploeg with data from rs...
    PersoonBag persoon = new PersoonBag();
    persoon.setPloeg(ploeg);
    // populate persoon with remaining data from rs...
    persoonList.add(persoon);
}