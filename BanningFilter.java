import java.util.Scanner;
public class BanningFilter {
  public static void main(String[] args) 
    {Scanner s = new Scanner(System.in); 
      String input1 = s.nextLine();
      String input1LowerCase = input1.toLowerCase();
      String[] bannedWords = input1LowerCase.split(" ");
      String censorship = "*&#$%*&#$%*&#$%*&#$%*&#$%*&#$%*&#$%*&#$%*&#$%*&#$%"; //50 char as the longest word in the dicctionary 
      
while (s.hasNext()) {
    String input2 = s.nextLine();
        String[] tweet = input2.split("(?<!^)\\b");
         for (int j=0; j<tweet.length; j++){
            for (String foundBannedWords : bannedWords){
                String reWtrite = censorship.substring(0,foundBannedWords.length());
                if (tweet [j].toLowerCase().equals(foundBannedWords))tweet[j]=reWtrite;
        
            } 
            System.out.print(tweet[j]);
        }
        System.out.println();
    }
  }}
