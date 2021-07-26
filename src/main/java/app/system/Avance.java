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

        StringBuilder resumenGeneral = new StringBuilder();

        resumenGeneral.append("\nAvance: ").append(100*((totalVacunadosCompletos+totalVacunadosParciales)/total)).append("%")
                .append( "\nCobertura: ").append(100*(totalVacunadosCompletos/total)).append("%")
                .append("\nCentros: ").append(cantidadCentros)
                .append("\nCompletos: ").append(totalVacunadosCompletos)
                .append("\nParciales: ").append(totalVacunadosParciales);

        final String resultado = resumenGeneral.toString();
        log.info(resultado);

    }

    public static void verResumenPorRangosDeEdad(){
        var rangos = Components.rangos();
        var centros = Components.centros();

        HashMap<String, Integer> porcentajes = new HashMap<>();
        for(var centro: centros.entrySet()){
            for(final var completo: centro.getValue().completos().entrySet()){
                porcentajes.put(completo.getKey(), 100*(completo.getValue()/rangos.get(completo.getKey())));
            }
        }

        StringBuilder resumenPorRangos = new StringBuilder();
        for(var porcentaje : porcentajes.entrySet()){
            resumenPorRangos.append("\n").append(porcentaje.getValue().toString()).append("%");
        }
        final String resultado = resumenPorRangos.toString();
        log.info(resultado);
    }

}
