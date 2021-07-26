package app;

import app.system.*;
import app.component.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void main(){
        var instance = new App();
        App.main(null);
        assertTrue(true);
    }

    @Test
    public void test(){
        assertTrue(Sesion.ingresar("juan", "nauj"));
        assertFalse(Sesion.ingresar("juan", "naujj"));

        Registro.definirRangoEdad("80 a más", 647355);
        Registro.definirRangoEdad("70 a 79", 1271842);
        Registro.definirRangoEdad("60 a 69", 2221241);
        Registro.definirRangoEdad("50 a 59", 3277134);
        Registro.definirRangoEdad("40 a 49", 4183174);
        Registro.definirRangoEdad("30 a 39", 5031117);
        Registro.definirRangoEdad("18 a 29", 6303670);


        Registro.activarCentro("Campo");
        Registro.activarCentro("El cielo");

        Registro.inactivarCentro("Campo");

        assertFalse(Registro.anadirVacunadosCompletos("Campo", "18 a 29", 1000000));
        assertTrue(Registro.anadirVacunadosCompletos("El cielo", "18 a 29", 1000000));

        assertFalse(Registro.anadirVacunadosParciales("Campo", "18 a 29", 1000000));
        assertTrue(Registro.anadirVacunadosParciales("El cielo", "18 a 29", 1000000));


        Avance.verResumenGeneral();
        Avance.verResumenPorRangosDeEdad();
    }
}