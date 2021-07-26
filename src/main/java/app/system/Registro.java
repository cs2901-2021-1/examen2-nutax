package app.system;

import app.component.*;

import java.util.HashMap;
import java.util.logging.Logger;

public class Registro {
    private Registro(){}

    private static Logger log = Logger.getLogger(Registro.class.getName());

    public static void definirRangoEdad(String rangoEdad, Integer cantidad){
        Components.rangos().put(rangoEdad, cantidad);
    }

    public static void activarCentro(String nombreCentro){
        var centros = Components.centros();
        centros.computeIfAbsent(nombreCentro, k -> new Centro(new HashMap<>(), new HashMap<>(), true));
        var centro = centros.get(nombreCentro);
        centros.put(nombreCentro, new Centro(centro.completos(), centro.parciales(), true));
    }

    public static void inactivarCentro(String nombreCentro){
        var centros = Components.centros();
        centros.computeIfAbsent(nombreCentro, k -> new Centro(new HashMap<>(), new HashMap<>(), false));
        var centro = centros.get(nombreCentro);
        centros.put(nombreCentro, new Centro(centro.completos(), centro.parciales(), false));
    }

    public static boolean anadirVacunadosCompletos(String nombreCentro, String rangoEdad, Integer cantidad){
        var centros = Components.centros();
        centros.computeIfAbsent(nombreCentro, k -> new Centro(new HashMap<>(), new HashMap<>(), true));
        var centro = centros.get(nombreCentro);
        if(centro.activo()){
            centro.completos().computeIfPresent(rangoEdad, (k,v)-> v + cantidad);
            centro.completos().computeIfAbsent(rangoEdad, k-> cantidad);
            centros.put(nombreCentro, new Centro(centro.completos(), centro.parciales(), true));
            return true;
        }else{
            return false;
        }
    }

    public static boolean anadirVacunadosParciales(String nombreCentro, String rangoEdad, Integer cantidad){
        var centros = Components.centros();
        centros.computeIfAbsent(nombreCentro, k -> new Centro(new HashMap<>(), new HashMap<>(), true));
        var centro = centros.get(nombreCentro);
        if(centro.activo()){
            centro.parciales().computeIfPresent(rangoEdad, (k,v)-> v + cantidad);
            centro.parciales().computeIfAbsent(rangoEdad, k-> cantidad);
            centros.put(nombreCentro, new Centro(centro.completos(), centro.parciales(), true));
            return true;
        }else{
            return false;
        }
    }
}
