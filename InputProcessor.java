import java.util.*;

/**
 * This class is responsible for processing input data and creating objects accordingly.
 */
public class InputProcessor {
    private List<Classroom> classrooms = new ArrayList<>();
    private List<Decoration> decorations = new ArrayList<>();

    /**
     * Processes the input data and creates objects of Classroom and Decoration classes.
     *
     * @param itemsInput An array containing input lines
     */
    public void ObjectCreator(String[] itemsInput) {
        for (String line : itemsInput) {
            String[] parts = line.split("\t");
            if (parts[0].equals("CLASSROOM")) {
                // Create a Classroom object
                Classroom classroom = new ClassroomBuilder()
                        .setName(parts[1])
                        .setShape(parts[2])
                        .setWidth(Double.parseDouble(parts[3]))
                        .setLength(Double.parseDouble(parts[4]))
                        .setHeight(Double.parseDouble(parts[5]))
                        .build();
                classrooms.add(classroom);
            } else if (parts[0].equals("DECORATION")) {
                // Create a Decoration object
                String[] decorationInfo = new String[parts.length - 1];
                System.arraycopy(parts, 1, decorationInfo, 0, parts.length - 1);
                decorations.add(new DecorationBuilder()
                        .setName(decorationInfo[0])
                        .setType(decorationInfo[1])
                        .setPrice(Double.parseDouble(decorationInfo[2]))
                        .setAreaOrTileSize(parts.length > 4 ? Double.parseDouble(decorationInfo[3]) : 0)
                        .build());
            }
        }
    }
    public List<Classroom> getClassrooms() {
        return classrooms;
    }
    public List<Decoration> getDecorations() {
        return decorations;
    }
}