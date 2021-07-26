package app.system;

import app.component.*;

import java.util.HashMap;
import java.util.logging.Logger;

public class Avance {
    private Avance(){}

    private static Logger log = Logger.getLogger(Avance.class.getName());


    public static void verResumenGeneral(){
        var rangos = Components.rangos();
        var centros = Components.centros();

        int total = 0;
        for(var rango: rangos.entrySet()){
            total = total + rango.getValue();
        }

        Integer cantidadCentros = centros.size();
        Integer totalVacunadosCompletos = 0;
        Integer totalVacunadosParciales = 0;
        for(var centro: centros.entrySet()){
            for(final var completo: centro.getValue().completos().entrySet()){
                totalVacunadosCompletos = totalVacunadosCompletos + completo.getValue();
            }
            for(final var parcial: centro.getValue().parciales().entrySet()){
                totalVacunadosParciales = totalVacunadosParciales + parcial.getValue();
            }
        }

        final String resumenGeneral = "\nAvance: " + String.valueOf(100*((totalVacunadosCompletos+totalVacunadosParciales)/total)) + "%"
                + "\nCobertura: " + String.valueOf(100*(totalVacunadosCompletos/total)) + "%"
                + "\nCentros: " + String.valueOf(cantidadCentros)
                + "\nCompletos: " + String.valueOf(totalVacunadosCompletos)
                + "\nParciales: " + String.valueOf(totalVacunadosParciales);

        log.info(resumenGeneral);

    }

    public static void verResumenPorRangosDeEdad(){
        var rangos = Components.rangos();
        var centros = Components.centros();

        HashMap<String, Integer> porcentajes = new HashMap<>();
        for(var centro: centros.entrySet()){
            var nombreCentro = centro.getKey();
            for(final var completo: centro.getValue().completos().entrySet()){
                porcentajes.put(completo.getKey(), 100*(completo.getValue()/rangos.get(completo.getKey())));
            }
        }

        StringBuilder resumenPorRangos = new StringBuilder();
        for(var porcentaje : porcentajes.entrySet()){
            resumenPorRangos.append("\n").append(porcentaje.getValue().toString()).append("%");
        }
        log.info(resumenPorRangos.toString());
    }

}
