    import java.util.*;
    public class Bai1{
        public static double dientichxapxi(double r){
            double area  = 0.0;
            int n = 1000000;
            double step = r / n;
            for(double x = -r; x <= r; x += step){
                double y = Math.sqrt((r*r)-(x*x));
                area += step * (y + y);
            }
            return area;
            }  
        public static void main(String[] args){    
            double r  = 5 ;
            System.out.println(dientichxapxi(r));      
            System.out.println(Math.PI * (r*r));
        }    
        }