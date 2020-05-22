//# import this class
import javax.xml.bind.DatatypeConverter;

//# declare byte array
public static byte[] imageBytes;

//# String into imageBytes convert with... (writes byte integers from hex values)
imageBytes = DatatypeConverter.parseHexBinary( my_Hex_String );