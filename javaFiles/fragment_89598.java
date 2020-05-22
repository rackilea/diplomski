String sql = "SELECT DISTINCT attra.attractid, attractname, x, y, z, age" +
                           ", weight, height, duration, price, status" +
              " FROM attraction attra" +
              " JOIN attrib_bridge ab ON attra.attractId = ab.attractId" +
              " JOIN attribute attri ON ab.attributeId = attri.attributeid" +
             " WHERE attri.attributename IN ?";
try (PreparedStatement ps = connection.prepareStatement(sql)) {
    ps.setString(1, Arrays.toString(obj));
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            // Process row here
        }
    }
}