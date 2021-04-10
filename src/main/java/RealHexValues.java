import java.util.HashMap;
import java.util.Map;

public class RealHexValues {

    public static final String PDF_HEX_VALUE = "25504446";
    public static final String GIF_HEX_VALUE = "47494638";
    public static final String JPG_HEX_VALUE = "ffd8ffe0";

    Map<String, String> hexValues = new HashMap<>();

    public String getHexValue(String key) {
        hexValues.put("pdf", PDF_HEX_VALUE);
        hexValues.put("gif", GIF_HEX_VALUE);
        hexValues.put("jpg", JPG_HEX_VALUE);
        return hexValues.get(key);
    }
}
