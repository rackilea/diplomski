public class Mapper
{
    public static void main(String[] args)
    {
        int zoom = 11;
        double lat = -33.77651d;
        double lon = 150.94712d;
        System.out.println("http://localhost/osm/"
            + getTileNumber(lat, lon, zoom) + ".png");
    }

    public static String getTileNumber(double lat, double lon, int zoom)
    {
        int xtile = (int)Math.floor((lon + 180) / 360 * (1<<zoom));
        int ytile = (int)Math.floor((1 - Math.log(Math.tan(Math.toRadians(lat))
            + 1 / Math.cos(Math.toRadians(lat))) / Math.PI) / 2 * (1<<zoom));
        return ("" + zoom + "/" + xtile + "/" + ytile);
    }
}