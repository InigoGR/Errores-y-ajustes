import fundamentos.*;
/**
 * Programa que a partir de datos experimentales realiza un ajuste de los datos a una función del tipo      
 * y=ax^m
 * 
 * @author Iñigo González Ruiz 
 * @version 07/03/2017)
 */
public class Errores
{
    // numero de datos
    private int n;
    // grado de la función
    private double m;

    /**
     * Constructor for objects of class Errores
     */
    public Errores(int n, int grado)
    {
        this.n = n;
        m = grado;
    }

    /**
     * Método para recoger datos experimentales de la variable x a través de una tabla
     * 
     * @return     array con valores numéricos de los datos 
     */
    public double[] recogeDatosX()
    {
            //Crea tabla para introducir datos y array para guardarlos
            Lectura Datos=new Lectura("Datos X");
            double[] data = new double[n];
            //Se introducen los datos
            for(int i=0;i<n;i++)
            {    
                Datos.creaEntrada("Dato "+(i+1), 0);
            }
            Datos.esperaYCierra();
            //Se guardan los datos en un array
            for(int i=0;i<n;i++)
            {    
                data[i] = Datos.leeDouble("Dato "+(i+1));
            }
            return data;
        
    }
    /**
     * Método para recoger datos experimentales de la variable y a través de una tabla
     * 
     * @return  array con valores numéricos de los datos 
     */
    public double[] recogeDatosY()
    {
            //Crea tabla para introducir datos y array para guardarlos
            Lectura Datos=new Lectura("Datos Y");
            double[] data = new double[n];
            //Se introducen los datos
            for(int i=0;i<n;i++)
            {    
                Datos.creaEntrada("Dato "+(i+1), 0);
            }
            Datos.esperaYCierra();
            //Se guardan los datos en un array
            for(int i=0;i<n;i++)
            {    
                data[i] = Datos.leeDouble("Dato "+(i+1));
            }
            return data;
        
    }
     /**
     * Método para recoger errores experimentales a través de una tabla
     * 
     * @return  array con valores numéricos de los datos 
     */
    public double[] recogeDatosDelta()
    {
            //Crea tabla para introducir datos y array para guardarlos
            Lectura Datos=new Lectura("Datos DeltaY");
            double[] data = new double[n];
            //Se introducen los datos
            for(int i=0;i<n;i++)
            {    
                Datos.creaEntrada("Dato "+(i+1), 0);
            }
            Datos.esperaYCierra();
            //Se guardan los datos en un array
            for(int i=0;i<n;i++)
            {    
                data[i] = Datos.leeDouble("Dato "+(i+1));
            }
            return data;
        
    }
    /**
     * Método para realizar ajuste  (Obsoleto)
     * 
     * @return  valor de la pendiente  
     */
    public double pendiente(double[] x, double[] y)
    {
        double r=0;
        double t=0;
        for(int i = 0; i<n; i++)
        {
            r=r+y[i]*Math.pow(x[i],m);
            t=t+Math.pow(x[i],2*m);
        }
        double a=r/t;
        return a;
    }
    /**
     * Método para calcular error   (Obsoleto)
     * 
     * @return valor del error de la pendiente
     */
    public double errorPendiente(double[] x, double[] D)
    {
        double r=0;
        double t=0;
        for(int i = 0; i<n; i++)
        {
            r=r+Math.abs(Math.pow(x[i],m))*D[i];
            t=t+Math.pow(x[i],2*m);
        }
        double a=r/t;
        return a;
    }
    /**
     * Método para tabla
     * 
     */
    public void tabla(double[] x, double[] y, double[] D)
    {
        System.out.println("\\begin{table}[H]");
        System.out.println("\\begin{center}");
        System.out.println("\\begin{tabular}{ c c c c c c c c c}");
        System.out.println("\\hline");
        System.out.println("$x_i$ & $y_i$ & $\\delta y_i$ & $x_i^m$ & $|x_i^m|$ & $x_i^{2m}$ & $y_i x_i^m$ & $|x_i^m| \\delta y_i$ \\\\");
        System.out.println("\\hline");
        for(int i = 0; i<n; i++)
        {
            double a=x[i];
            double b=y[i];
            double c=D[i];
            double d=Math.pow(a,m);
            double e=Math.abs(d);
            double f=Math.pow(a,2*m);
            double g=b*d;
            double h=e*c;
            System.out.printf("%7.2f & %7.2f & %7.1f & %7.2f & %7.2f & %7.2f & %7.2f & %7.1f \\\\ %n",a,b,c,d,e,f,g,h);
        }
        System.out.println("\\end{tabular}");
        System.out.println("\\caption{ }");
        System.out.println("\\end{center}");
        System.out.println("\\end{table}");
        double r=0;
        double t=0;
        double u=0;
        for(int i = 0; i<n; i++)
        {
            r=r+y[i]*Math.pow(x[i],m);
            t=t+Math.pow(x[i],2*m);
            u=u+Math.abs(Math.pow(x[i],m))*D[i];
        }
        double a=r/t;
        double b=u/t;
        System.out.println("\\centering");
        System.out.println("\\vspace{-1cm}");
        System.out.println("Pendiente: "+a+"\\\\");
        System.out.println("Error: "+b+"\\\\");
        System.out.println("$\\sum\\limits_{i=1}^n y_ix_i^m="+r+"$\\ \\");
        System.out.println("$\\sum\\limits_{i=1}^n x_i^{2m}="+t+"$\\ \\");
        System.out.println("$\\sum\\limits_{i=1}^n |x_i^m| \\Delta y_i="+u+"$\\ \\");
        System.out.println("\\vspace{0,8cm}");
    }
}
