package app.system;

import java.util.logging.Logger;



public class Sesion {
    private Sesion(){}

    private static Logger log = Logger.getLogger(Sesion.class.getName());

    public static boolean ingresar(String usuario, String contrasena){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contrasena);
        var logged = stringBuilder.reverse().toString().equals(usuario);
        if(logged){
            log.info("Usuario y/o contraseña incorrectos");
        }else{
            log.info("Ingreso exitoso");
        }
        return logged;
    }

    public static void salir(){
        log.info("Sesión terminada");
    }
}
