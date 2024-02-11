import java.util.Scanner;

class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String inputString = scanner.nextLine();
        String reversedString = reverseString(inputString);
        System.out.println(reversedString);
    }

    public static String reverseString(String stringHolder){
        char[] charArray = stringHolder.toCharArray();
        for(int i=0; i < charArray.length / 2; i++){
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = temp;
        }
        return new String(charArray);
    }
}