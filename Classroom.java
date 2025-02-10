/**
 * Represents a classroom with its characteristics such as name, shape, width, length, and height.
 */
public class Classroom {
    private String className;
    private String classShape;
    private double classWidth;
    private double classLength;
    private double classHeight;

    /**
     * Constructs a new Classroom object with the specified parameters.
     *
     * @param className   The name of the classroom
     * @param classShape  The shape of the classroom (e.g., "Circular" or "Rectangular")
     * @param classWidth  The width of the classroom
     * @param classLength The length of the classroom
     * @param classHeight The height of the classroom
     */
    public Classroom(String className, String classShape, double classWidth, double classLength, double classHeight) {
        this.className = className;
        this.classShape = classShape;
        this.classWidth = classWidth;
        this.classLength = classLength;
        this.classHeight = classHeight;
    }

    public String getClassName() {
        return className;
    }

    public String getClassShape() {
        return classShape;
    }

    public double getClassWidth() {
        return classWidth;
    }

    public double getClassLength() {
        return classLength;
    }

    public double getClassHeight() {
        return classHeight;
    }
}
