import java.util.*;

public class ProfanityF {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine().trim().toLowerCase();
        String[] splitStr = inputLine.split("\\s+");
        List<String> swearWords = new ArrayList<String>();
        swearWords = Arrays.asList(splitStr);

        String[] filterSigns = { "*", "&", "#", "$", "%" };
        HashMap<String, String> wordsToFilter = new HashMap<>();

        for (int i = 0; i < swearWords.size(); i++) {
            String wordBefore = swearWords.get(i);
            String wordAfter = "";
            for (int j = 0; j < wordBefore.length(); j++) {
                wordAfter += filterSigns[j % 5];
            }
            wordsToFilter.put(wordBefore, wordAfter);
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            Scanner wordScanner = new Scanner(line);
            while (wordScanner.hasNext()) {
                String nextWord = wordScanner.next();
                String end = nextWord.substring(nextWord.length() - 1);
                boolean printEnd = false;
                switch (end) {
                    case ".":
                        printEnd = true;
                        break;
                    case ",":
                        printEnd = true;
                        break;
                    case "!":
                        printEnd = true;
                        break;
                    case "?":
                        printEnd = true;
                        break;
                }
                nextWord = cleanWord(nextWord);
                for (int i = 0; i < swearWords.size(); i++) {
                    String nextSwearWord = swearWords.get(i);
                    if (nextWord.toLowerCase().equals(nextSwearWord)) {
                        nextWord = wordsToFilter.get(nextSwearWord);
                    }
                }
                if (!printEnd) {
                    System.out.print(nextWord + " ");
                } else {
                    System.out.print(nextWord + end + " ");
                }
            }
            wordScanner.close();
            System.out.println();
        }
    }

    public static String cleanWord(String str) {
        String tmp;
        tmp = str;
        tmp = tmp.replace(",", "");
        tmp = tmp.replace(".", "");
        tmp = tmp.replace("!", "");
        tmp = tmp.replace("?", "");
        return tmp;
    }
}