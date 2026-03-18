import java.util.*;

// Tạo một Class Point (Điểm) để lưu trữ toạ độ x, y
class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Ghi đè phương thức so sánh để sắp xếp theo x, nếu x bằng thì theo y
    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

public class Bai3 {


    public static long crossProduct(Point O, Point A, Point B) {
        return (long)(A.x - O.x) * (B.y - O.y) - (long)(A.y - O.y) * (B.x - O.x);
    }

    public static List<Point> findConvexHull(List<Point> points) {
        int n = points.size();
        if (n <= 3) return new ArrayList<>(points);

        Collections.sort(points);

        List<Point> hull = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points.get(i)) >= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points.get(i));
        }

        // 3. Xây dựng nửa DƯỚI (Lower Hull)
        int upperHullSize = hull.size();
        for (int i = n - 2; i >= 0; i--) {
            while (hull.size() > upperHullSize && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points.get(i)) >= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points.get(i));
        }

        hull.remove(hull.size() - 1);

        return hull;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        List<Point> warningStations = findConvexHull(points);
        
        // In kết quả
        for (Point p : warningStations) {
            System.out.println(p.x + " " + p.y);
        }
        
        scanner.close();
    }
}