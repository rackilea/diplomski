/** superclass for medicions */
abstract class Medicion {
    public int tipoTransaccion;
    public ResultadoConsultaNegocioStandard standard;
}

/** those medicions with canals, referencing medicions with aplicacions */
class MedicionCanal extends Medicion {
    public String canal;
    public MedicionAplicacion medicionAplicacion;
}

/** those medicions with aplicacions */
class MedicionAplicacion extends Medicion {
    public String aplicacion;
}