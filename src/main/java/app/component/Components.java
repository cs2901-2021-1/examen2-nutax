package app.component;

import java.util.HashMap;
import java.util.Map;

public class Components {
    private Components(){}

    private static final Map<String, Centro> CENTROS = new HashMap<>();
    public static Map<String, Centro> centros(){return CENTROS;}

    private static final Map<String, Integer> RANGOS = new HashMap<>();
    public static Map<String, Integer> rangos(){return RANGOS;}

}
