import org.apache.commons.codec.binary.Base64;

@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
public String get(@PathVariable String id) {
    final String realId = new String(new Base64(true).encodeBase64URLSafe(id));
    [...]
}