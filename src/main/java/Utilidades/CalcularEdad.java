package Utilidades;



import org.testng.Assert;

import java.util.logging.Logger;

public class CalcularEdad {
    public static Logger laa = Logger.getLogger(CalcularEdad.class.getName());


    public static void main(String[] args) {

        Assert.assertTrue(valida("perra"));


    }

    public  static boolean valida(String paralabra){
        if (!(paralabra.contains("perra"))){
            System.out.println("tueeeeeeeeeeeeeee");
            return true;
        }

        return false;


    }

}