public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    // constructor
    public Circle() {
        this.radius = 1.0;
    }

    // Constructor with specified radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Calculate area
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Calculate perimeter (circumference)
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Implement compareTo for Comparable interface
    @Override
    public int compareTo(Circle other) {
        if (this.radius > other.radius) {
            return 1;
        } else if (this.radius < other.radius) {
            return -1;
        } else {
            return 0;
        }
    }

    // Override equals method to compare Circle objects based on radius
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            return this.radius == other.radius;
        }
        return false;
    }

    // Override toString for better output representation
    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}
