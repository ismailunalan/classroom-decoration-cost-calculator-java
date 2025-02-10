import java.util.Collections;
import java.util.List;

/**
 * The main class responsible for orchestrating the decoration cost calculation process.
 */
public class Main {
    /**
     * The main method that starts the program execution.
     *
     * @param args Command line arguments containing file paths
     */
    public static void main(String[] args) {
        // Clear the output file
        FileOutput.writeToFile(args[2], "", false, false);

        // Read input files
        String itemsFilePath = args[0];
        String decorationFilePath = args[1];
        String[] itemsInput = FileInput.readFile(itemsFilePath, true, true);
        String[] decorationInput = FileInput.readFile(decorationFilePath, true, true);

        // Process input data
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.ObjectCreator(itemsInput);

        // Retrieve created objects
        List<Classroom> classrooms = inputProcessor.getClassrooms();
        List<Decoration> decorations = inputProcessor.getDecorations();

        // Calculate decoration costs and write to file
        DecorationCostCalculator calculator = new DecorationCostCalculator(classrooms, decorations);
        calculator.calculateAndWriteToFile(decorationInput, decorations, args);
    }
}
