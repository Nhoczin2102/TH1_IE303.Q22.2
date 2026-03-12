public class Bai2 {
    public static double xapxi(){
        double r = 1;
        double area = 0;
        int n = 1000000;
        double step = r / n;
        for(double x = -r ; x <= r; x += step){
            double y = Math.sqrt((r*r)- (x*x));
            area += step * (y+y);
        }
        return area;
    }
    public static void main (String[] args){
        System.out.println(xapxi());
        System.out.println(Math.PI);
    }
}
