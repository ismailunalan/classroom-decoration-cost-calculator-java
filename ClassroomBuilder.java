/**
 * Builder class for creating instances of the {@link Classroom} class.
 */
public class ClassroomBuilder {
    private String className;
    private String classShape;
    private double classWidth;
    private double classLength;
    private double classHeight;


    public ClassroomBuilder setName(String className) {
        this.className = className;
        return this;
    }

    public ClassroomBuilder setShape(String classShape) {
        this.classShape = classShape;
        return this;
    }

    public ClassroomBuilder setWidth(double classWidth) {
        this.classWidth = classWidth;
        return this;
    }

    public ClassroomBuilder setLength(double classLength) {
        this.classLength = classLength;
        return this;
    }

    public ClassroomBuilder setHeight(double classHeight) {
        this.classHeight = classHeight;
        return this;
    }

    /**
     * Builds and returns an instance of the {@link Classroom} class using the provided parameters.
     *
     * @return An instance of the {@link Classroom} class
     */
    public Classroom build() {
        return new Classroom(className, classShape, classWidth, classLength, classHeight);
    }
}
