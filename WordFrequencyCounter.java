import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequencies(String filePath) throws IOException {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s.,!?;:\"()\\[\\]{}]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordFrequencies;
    }

    public static void main(String[] args) {
        String filePath = "src/text.txt";

        try {
            Map<String, Integer> frequencies = countWordFrequencies(filePath);
            System.out.println("Частота слів:");
            frequencies.forEach((word, frequency) -> System.out.println("'" + word + "' : " + frequency));
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}
