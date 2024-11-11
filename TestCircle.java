public class TestCircle {
    public static void main(String[] args) {
        // Create Circle objects
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(7.0);
        Circle circle3 = new Circle(5.0); // Same radius as circle1 to test equals

        // Test getRadius, getArea, and getPerimeter methods
        System.out.println("Circle1 Radius: " + circle1.getRadius());
        System.out.println("Circle1 Area: " + circle1.getArea());
        System.out.println("Circle1 Perimeter: " + circle1.getPerimeter());
        
        System.out.println("\nCircle2 Radius: " + circle2.getRadius());
        System.out.println("Circle2 Area: " + circle2.getArea());
        System.out.println("Circle2 Perimeter: " + circle2.getPerimeter());

        // Test equals method
        System.out.println("\nTesting equals method:");
        System.out.println("Circle1 equals Circle2? " + circle1.equals(circle2)); // Expected: false
        System.out.println("Circle1 equals Circle3? " + circle1.equals(circle3)); // Expected: true

        // Test compareTo method
        System.out.println("\nTesting compareTo method:");
        System.out.println("Circle1 compareTo Circle2: " + circle1.compareTo(circle2)); // Expected: -1 (smaller)
        System.out.println("Circle2 compareTo Circle1: " + circle2.compareTo(circle1)); // Expected: 1 (larger)
        System.out.println("Circle1 compareTo Circle3: " + circle1.compareTo(circle3)); // Expected: 0 (equal)

        // Test toString method
        System.out.println("\nTesting toString method:");
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle3);
    }
}
