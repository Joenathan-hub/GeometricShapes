// File name must be exactly: ShapeDemo.java
public class ShapeDemo {

    // Requirement: Prints the area using a superclass array reference (Dynamic Binding)
    public static void printAreas(Shape[] shapes) {
        System.out.println("--- Polymorphic Area Metrics Report ---");
        for (Shape s : shapes) {
            System.out.printf("%s | Calculated Area: %.2f\n", s.toString(), s.getArea());
        }
    }

    // Requirement: Finds and prints the shape instance with the maximum area
    public static void largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            System.out.println("No shapes available.");
            return;
        }
        
        Shape maxShape = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > maxShape.getArea()) {
                maxShape = shapes[i];
            }
        }
        System.out.println("\n--- Peak Metric Shape Identified ---");
        System.out.printf("Largest Shape Details: %s with an Area of: %.2f\n", maxShape.toString(), maxShape.getArea());
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("1. DEMONSTRATING EXCEPTION HANDLING (TRY-CATCH BLOCK)");
        System.out.println("==================================================================");
        
        try {
            System.out.println("Attempting to construct an invalid triangle with sides [2.0, 2.0, 50.0]...");
            Triangle badTriangle = new Triangle(2.0, 2.0, 50.0, "Red", true);
        } catch (InvalidShapeException e) {
            System.out.println(">>> Custom Exception Successfully Caught!");
            System.out.println(">>> Intercepted Message: " + e.getMessage());
        }
        System.out.println("==================================================================\n");

        System.out.println("==================================================================");
        System.out.println("2. INITIALIZING POLYMORPHIC ARRAY AND CORES METHODS");
        System.out.println("==================================================================");
        
        Shape[] shapeGroup = new Shape[3];
        shapeGroup[0] = new Circle(4.0, "Blue", true);
        shapeGroup[1] = new Rectangle(5.0, 6.0, "Green", false);
        shapeGroup[2] = new Triangle(3.0, 4.0, 5.0, "Yellow", true);

        printAreas(shapeGroup);
        largest(shapeGroup);
        System.out.println("==================================================================\n");

        System.out.println(">>> Executing resize operations: Multiplying linear scales by factor of 2.0...");
        for (Shape s : shapeGroup) {
            s.resize(2.0);
        }

        System.out.println("\n==================================================================");
        System.out.println("3. METRICS REPORT POST DIMENSIONAL TRANSFORMATION (RESIZING)");
        System.out.println("==================================================================");
        printAreas(shapeGroup);
        largest(shapeGroup);
        System.out.println("==================================================================");
    }
}