// File name must be exactly: Shape.java
public abstract class Shape {
    protected String color = "white";
    protected boolean filled;

    // Default constructor
    public Shape() { }

    // Overloaded constructor
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Abstract methods to be overridden by concrete subclasses
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor); // Scales linear dimensions

    @Override
    public String toString() {
        return "Shape [Color=" + color + ", Filled=" + filled + "]";
    }
}