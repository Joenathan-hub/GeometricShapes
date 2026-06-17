// File name must be exactly: Triangle.java
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        
        // Check for non-positive sides
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidShapeException("Triangle Error: Sides must be positive values.");
        }
        
        // Enforce Triangle Inequality Theorem
        if ((side1 + side2 <= side3) || (side1 + side3 <= side2) || (side2 + side3 <= side1)) {
            throw new InvalidShapeException("Triangle Error: Violates Triangle Inequality constraints.");
        }
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        // Heron's Formula for semi-perimeter
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize Error: Factor must be positive. Provided: " + factor);
        }
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }

    @Override
    public String toString() {
        return "Triangle [" + super.toString() + ", Side1=" + side1 + ", Side2=" + side2 + ", Side3=" + side3 + "]";
    }
}