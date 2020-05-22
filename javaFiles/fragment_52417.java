double utmZoneCenterLongitude = ...  // Center lon of zone, example: zone 10 = -123
int zoneNumber = ...                 // zone number, example: 10
double latitude, longitude = ...     // lat, lon in degrees

MathTransformFactory mtFactory = ReferencingFactoryFinder.getMathTransformFactory(null);
ReferencingFactoryContainer factories = new ReferencingFactoryContainer(null);

GeographicCRS geoCRS = org.geotools.referencing.crs.DefaultGeographicCRS.WGS84;
CartesianCS cartCS = org.geotools.referencing.cs.DefaultCartesianCS.GENERIC_2D;

ParameterValueGroup parameters = mtFactory.getDefaultParameters("Transverse_Mercator");
parameters.parameter("central_meridian").setValue(utmZoneCenterLongitude);
parameters.parameter("latitude_of_origin").setValue(0.0);
parameters.parameter("scale_factor").setValue(0.9996);
parameters.parameter("false_easting").setValue(500000.0);
parameters.parameter("false_northing").setValue(0.0);

Map properties = Collections.singletonMap("name", "WGS 84 / UTM Zone " + zoneNumber);
ProjectedCRS projCRS = factories.createProjectedCRS(properties, geoCRS, null, parameters, cartCS);

MathTransform transform = CRS.findMathTransform(geoCRS, projCRS);

double[] dest = new double[2];
transform.transform(new double[] {longitude, latitude}, 0, dest, 0, 1);

int easting = (int)Math.round(dest[0]);
int northing = (int)Math.round(dest[1]);