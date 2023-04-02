import java.io.BufferedReader;
import java.io.IOException;

public class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public static Point read(BufferedReader bufferedReader) throws IOException {
    System.out.println("Введите координаты точки:");
    String coordinates = bufferedReader.readLine();
    return parse(coordinates);
  }

  public static Point parse(String coordinates) {
    int separator = coordinates.indexOf(',');
    int x = Integer.parseInt(coordinates.substring(0, separator));
    int y = Integer.parseInt(coordinates.substring(separator + 1).trim());

    return new Point(x, y);
  }

  public static int search_coordinate_quarter(Point coordinate) {
    int x = coordinate.getX();
    int y = coordinate.getY();
    if (y > 0 && x > 0) {
      return 1;
    }
    if (y < 0 && x > 0) {
      return 2;
    }

    if (y < 0 && x < 0) {
      return 3;
    }
    return 4;
  }

  public static int positionPointRelativeToCircle(BufferedReader br, Point point) throws IOException {
    System.out.println("Enter the radius of the circle");
    int radius = Integer.parseInt(br.readLine());
    double v = Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2);
    if (v < Math.pow(radius, 2)) {
      return 1; // находится внутри окружности
    }
    if (v == Math.pow(radius, 2)) {
      return 2; // находится на окружности
    }
    return 3;// находится вне окружности
  }

}

