import java.util.List;
/**
 * This class calculates the cost of decoration for classrooms and writes the result to a file.
 */
public class DecorationCostCalculator {
    private List<Classroom> classrooms;
    private List<Decoration> decorations;

    /**
     * Constructor for DecorationCostCalculator class.
     *
     * @param classrooms   List of classrooms
     * @param decorations  List of decorations
     */
    public DecorationCostCalculator(List<Classroom> classrooms, List<Decoration> decorations) {
        this.classrooms = classrooms;
        this.decorations = decorations;
    }

    /**
     * Calculates the decoration cost for classrooms and writes the result to a file.
     *
     * @param decorationInput  Array containing decoration information
     * @param decorations      List of decorations
     * @param args             Command line arguments
     */
    public void calculateAndWriteToFile(String[] decorationInput, List<Decoration> decorations, String[] args){
        double totalCost = 0;
        for (String decor : decorationInput){
            String[] decoration = decor.split("\t");
            String className = decoration[0];
            String nameOfWallDecoration = decoration[1];
            String nameOfFloorDecoration = decoration[2];
            String tempName = "";
            for (Decoration d : decorations){
                if (d.getDecorationName().equals(nameOfWallDecoration)){
                    tempName = d.getDecorationType();
                }
            }
            //Does the calculations and prints the result.
            for (Classroom classroom : classrooms) {
                if (classroom.getClassName().equals(className)) {
                    double wallCost = calculateWallCost(classroom, nameOfWallDecoration);
                    double flooringCost = calculateFlooringCost(classroom, nameOfFloorDecoration);
                    double totalClassroomCost = wallCost + flooringCost;
                    String wallDecorationUnit = getClassroomDecorationUnit(nameOfWallDecoration);
                    double type = (wallDecorationUnit.equals(" Tiles")) ? calculateWallTileCount(classroom, nameOfWallDecoration) : Math.ceil(calculateWallArea(classroom));
                    String content = String.format("Classroom %s used %.0f%s%s%s for walls and used %.0f Tiles for flooring, these costed %.0fTL.%n",
                            classroom.getClassName(),
                            type,
                            wallDecorationUnit,
                            !tempName.equals("Tile") ? " of " : "",
                            !tempName.equals("Tile") ? tempName : "",
                            Math.ceil(calculateFloorTileCount(classroom, nameOfFloorDecoration)),
                            Math.ceil(totalClassroomCost));
                    FileOutput.writeToFile(args[2],content,true,false);
                    totalCost += totalClassroomCost;
                }
            }
        }
        FileOutput.writeToFile(args[2], "Total price is: " + (int)Math.ceil(totalCost) + "TL.",true,false);
    }

    // Method to calculate the cost of wall decoration
    private double calculateWallCost(Classroom classroom, String decorationName) {
        double area = calculateWallArea(classroom);
        double pricePerSquareMeter = findDecorationPrice(decorationName);
        String decorationType = "" ;
        for (Decoration decor : decorations){
            if (decor.getDecorationName().equals(decorationName)){
                decorationType = decor.getDecorationType();
            }
        }
        if (decorationType.equals("Tile")){
            for(Decoration decor : decorations){
                if ( decor.getDecorationName().equals(decorationName)){
                    return Math.ceil(area / decor.getAreaOrTileSize()) * pricePerSquareMeter;
                }
            }
        }
        return area * pricePerSquareMeter;
    }

    // Method to calculate the area of wall
    private double calculateWallArea(Classroom classroom) {
        if (classroom.getClassShape().equalsIgnoreCase("Circle")) {
            return Math.PI * classroom.getClassWidth() * classroom.getClassHeight();
        } else {
            return (2 * (classroom.getClassWidth() + classroom.getClassLength()) * classroom.getClassHeight());
        }
    }

    //Finds the cost of the ground process
    private double calculateFlooringCost(Classroom classroom, String decorationName) {
        double tileCount = calculateFloorTileCount(classroom, decorationName);
        double pricePerTile = findDecorationPrice(decorationName);
        return tileCount * pricePerTile;
    }

    // Method to calculate the number of tiles required for wall decoration
    private double calculateWallTileCount(Classroom classroom, String decorationName) {
        double tileCount = 0;
        for (Decoration decor : decorations){
            if (decor.getDecorationName().equals(decorationName)){
                tileCount = calculateWallArea(classroom) / decor.getAreaOrTileSize();
            }
        }
        return Math.ceil(tileCount);
    }

    // Method to calculate the number of tiles required for flooring decoration
    private double calculateFloorTileCount(Classroom classroom, String decorationName) {
        double tileCount = 0;
        for (Decoration decor : decorations){
            if (decor.getDecorationName().equals(decorationName)){
                if (classroom.getClassShape().equalsIgnoreCase("Circle")){
                    tileCount = ((classroom.getClassWidth()/2)*(classroom.getClassWidth()/2)
                            * Math.PI) / decor.getAreaOrTileSize();
                }else {
                    tileCount = (classroom.getClassWidth() * classroom.getClassLength()) / decor.getAreaOrTileSize();
                }
            }
        }
        return Math.ceil(tileCount);
    }

    // Method to determine the unit of decoration for a classroom
    private String getClassroomDecorationUnit(String decorationName) {
        for (Decoration decor : decorations){
            if (decor.getDecorationName().equals(decorationName)){
                String decorationType = decor.getDecorationType();
                if (decorationType.equals("Tile")) {
                    return " Tiles";
                } else {
                    return "m2";
                }
            }
        }
        return "";
    }

    // Method to find the price of a decoration
    private double findDecorationPrice(String decorationName) {
        double price = 0;
        for (Decoration decor : decorations){
            if (decor.getDecorationName().equals(decorationName)){
                price = decor.getDecorationPrice();
            }
        }
        return price;
    }
}