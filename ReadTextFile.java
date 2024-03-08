
/**
 * Prints out all the words in a text file
 * 
 * Richard M. 
 * March 5, 2024
 */
import java.util.*;

import java.io.File;

public class ReadTextFile
{
    

    /**
     * Constructor for objects of class ReadTextFile
     */

   public static void main(String[] args){
       ArrayList<String> words = new ArrayList<String>();
       HashMap<String, Integer> wordCount = new HashMap<>();
       try{
           File myFile = new File("sampleText.txt");
           Scanner myReader = new Scanner(myFile);
           while(myReader.hasNext()){
               String item = myReader.next().replaceAll("[,!?./\\-;:{}'\"]","");
               words.add(item);
               System.out.println(item);
               if(!wordCount.containsKey(item)){
                   wordCount.put(item.toLowerCase(), 1);
               }
               else{
                   wordCount.put(item.toLowerCase(), wordCount.get(item) + 1);
               }
           }
           myReader.close();
       }
       catch(Exception e){
           System.out.println("No file!");
       }
       System.out.println(tenCommonWords(wordCount));
   }
   
   public static List<String> tenCommonWords(HashMap<String, Integer> wordCount){
       ArrayList<Integer> commonWordList = new ArrayList<>();
       for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            commonWordList.add(entry.getValue());
       }
       Collections.sort(commonWordList);
       Collections.reverse(commonWordList);
       System.out.println(commonWordList);
       List<Integer> tenCommonIndex = new ArrayList(Arrays.asList(commonWordList));
       tenCommonIndex = commonWordList.subList(0, 10);
       ArrayList<String> topTenWords = new ArrayList<>();
       for(Integer i : tenCommonIndex){
           for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
               System.out.println(topTenWords.contains(entry.getValue()));
               if(entry.getValue() == i && !(topTenWords.contains(entry.getValue()))){
                   topTenWords.add(entry.getKey());
               }
           }
       }
       return topTenWords;
   }

   
}
