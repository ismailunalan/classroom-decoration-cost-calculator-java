/**
 * Represents a decoration with its characteristics such as name, type, price, and area or tile size.
 */
public class Decoration {
    private String decorationName;
    private String decorationType;
    private double decorationPrice;
    private double areaOrTileSize;

    /**
     * Constructs a new Decoration object with the specified parameters.
     *
     * @param decorationName   The name of the decoration
     * @param decorationType   The type of the decoration
     * @param decorationPrice  The price of the decoration
     * @param areaOrTileSize   The area or tile size of the decoration
     */
    public Decoration(String decorationName, String decorationType, double decorationPrice, double areaOrTileSize) {
        this.decorationName = decorationName;
        this.decorationType = decorationType;
        this.decorationPrice = decorationPrice;
        this.areaOrTileSize = areaOrTileSize;
    }

    public String getDecorationName() {
        return decorationName;
    }

    public String getDecorationType() {
        return decorationType;
    }

    public double getDecorationPrice() {
        return decorationPrice;
    }

    public double getAreaOrTileSize() {
        return areaOrTileSize;
    }
}
