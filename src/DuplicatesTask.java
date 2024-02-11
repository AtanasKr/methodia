import java.util.HashMap;

public class DuplicatesTask {
    public static void main(String[] args) {
        String str = "aabcddeeefg";
        findDuplicates(str);
    }

    public static void findDuplicates(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] charHolder = str.toCharArray();

        for (char c : charHolder) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        System.out.println("Duplicate characters in the string:");
        for (HashMap.Entry<Character, Integer> element : charCountMap.entrySet()) {
            if (element.getValue() > 1) {
                System.out.println(element.getKey() + " - " + element.getValue() + " times");
            }
        }
    }
}