/**
 * Builder class for creating instances of the {@link Decoration} class.
 */
public class DecorationBuilder {
    private String decorationName;
    private String decorationType;
    private double decorationPrice;
    private double areaOrTileSize;

    /**
     * Sets the name of the decoration.
     *
     * @param decorationName The name of the decoration
     * @return This {@code DecorationBuilder} object
     */

    public DecorationBuilder setName(String decorationName) {
        this.decorationName = decorationName;
        return this;
    }

    public DecorationBuilder setType(String decorationType) {
        this.decorationType = decorationType;
        return this;
    }

    public DecorationBuilder setPrice(double decorationPrice) {
        this.decorationPrice = decorationPrice;
        return this;
    }

    public DecorationBuilder setAreaOrTileSize(double areaOrTileSize) {
        this.areaOrTileSize = areaOrTileSize;
        return this;
    }

    /**
     * Builds and returns an instance of the {@link Decoration} class using the provided parameters.
     *
     * @return An instance of the {@link Decoration} class
     */
    public Decoration build() {
        return new Decoration(decorationName, decorationType, decorationPrice, areaOrTileSize);
    }
}
