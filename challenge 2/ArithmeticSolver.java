import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticSolver {

    public static void main(String[] args) {
        try {
            // Open the input and output files
            BufferedReader inputReader = new BufferedReader(new FileReader("input.txt"));
            FileWriter outputWriter = new FileWriter("output.txt");

            // Read each line of the input file and process it
            String line;
            while ((line = inputReader.readLine()) != null) {
                // Use regex to extract the arithmetic expression from the line
                Pattern pattern = Pattern.compile("[0-9+\\-*/^().\\[\\]{}\\s]+=");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String expression = matcher.group().replace("=", "").trim();
                    // Calculate the result of the expression
                    String result = calculateExpression(expression);
                    // Write the expression and its result to the output file
                    outputWriter.write(expression + " = " + result + "\n");
                }
            }

            // Close the input and output files
            inputReader.close();
            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculateExpression(String expression) {
        // Evaluate the arithmetic expression using Java's ScriptEngine
        javax.script.ScriptEngineManager scriptEngineManager = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        try {
            Object result = scriptEngine.eval(expression);
            return String.valueOf(result);
        } catch (javax.script.ScriptException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
