import fundamentos.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Main
     */
    public static void main(String[] args)
    {
        Lectura Datos=new Lectura("Datos");
        int n;
        int m;
        Datos.creaEntrada("n ", 0);
        Datos.creaEntrada("m ", 0);
        Datos.esperaYCierra();
        n=Datos.leeInt("n ");
        m=Datos.leeInt("m ");
        Errores param= new Errores(n,m);
        double[] x=new double[n];
        double[] y=new double[n];
        double[] D=new double[n];
        x=param.recogeDatosX();
        y=param.recogeDatosY();
        D=param.recogeDatosDelta();
        param.tabla(x,y,D);
    }

    
}
