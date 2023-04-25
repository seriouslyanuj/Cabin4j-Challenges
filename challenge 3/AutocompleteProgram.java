import java.util.*;
import java.io.*;

public class AutocompleteProgram {
    public static void main(String[] args) throws IOException {
        Map<String, Double> weights = new HashMap<>();
        File file = new File("input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            String text = parts[1];
            double weight = Double.parseDouble(parts[0]);
            weights.put(text, weight);
        }

        Autocomplete autocomplete = new Autocomplete(weights);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a prefix: ");
            String prefix = scanner.nextLine();
            System.out.print("Enter the number of suggestions to display: ");
            int k = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline character
            

            List<String> suggestions = autocomplete.getTopK(prefix, k);

            System.out.println("Top " + k + " suggestions for prefix \"" + prefix + "\":");
            for (String suggestion : suggestions) {
                System.out.println(suggestion + " (" + weights.get(suggestion) + ")");
            }

            System.out.println();
        }
    }
}
