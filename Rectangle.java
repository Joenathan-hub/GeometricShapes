// File name must be exactly: Rectangle.java
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Rectangle Error: Dimensions must be positive.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize Error: Factor must be positive. Provided: " + factor);
        }
        this.width *= factor;
        this.height *= factor;
    }

    @Override
    public String toString() {
        return "Rectangle [" + super.toString() + ", Width=" + width + ", Height=" + height + "]";
    }
}