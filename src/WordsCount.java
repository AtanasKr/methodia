import java.util.HashMap;

public class WordsCount {
    public static void main (String[] args) {
        String text = "This is my testing text. This text is used for testing purposes. Use this text to test";
        HashMap<String, Integer> wordCounter = countWords(text);

        for(String word: wordCounter.keySet()){
            System.out.println(word + "/ times occurred: "+wordCounter.get(word));
        }
    }

    public static HashMap<String, Integer> countWords(String text) {
        HashMap<String, Integer> wordCounter = new HashMap<>();

        String[] words = text.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase(); //removes additional symbols like punctuation
            if (!words[i].isEmpty()) {
                wordCounter.put(words[i], wordCounter.getOrDefault(words[i], 0) + 1);
            }
        }
        return  wordCounter;
    }
}
