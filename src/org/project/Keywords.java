package org.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
 
public class Keywords 
{   
    
    public static HashMap<String,Integer> keywordSearch(String st) 
    {    
		HashMap<String,Integer> keywords= new HashMap<String, Integer>();
        //Creating wordCountMap which holds words as keys and their occurrences as values
        String data1[]={".",",","is","the","are","1","2","3","<",">","of","has","and","4","6","7","8","0","{","}","(",")",":",";"," ","=="," =","=","= "," ","can","a","in",",","i","am","to","they","then","to","you","your","that","up"};
         
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
     
        BufferedReader reader = null;
         
        try
        {
            //Creating BufferedReader object
             
            reader = new BufferedReader(new FileReader(st));
             
            //Reading the first line into currentLine
             
            String currentLine = reader.readLine();
             
            while (currentLine != null)
            {    
                //splitting the currentLine into words
                 
                String[] words = currentLine.toLowerCase().split("\\s+");
                 
                //Iterating each word
                 
                for (String word : words)
					
                {
					if(!word.isEmpty())
					{
                    if(wordCountMap.containsKey(word))
                    {    
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                     
                    //otherwise inserting the word as key and 1 as its value
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
					}
                }
				
				for (String data : data1)
				{
					if(wordCountMap.containsKey(data))
					{
						wordCountMap.remove(data);
					}
				}
                 
                //Reading next line into currentLine
                 
                currentLine = reader.readLine();
            }
             
            //Getting all the entries of wordCountMap in the form of Set
             
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
             
            //Creating a List by passing the entrySet
             
            List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
             
            //Sorting the list in the decreasing order of values 
             
            Collections.sort(list, new Comparator<Entry<String, Integer>>() 
            {
                @Override
                public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) 
                {
                    return (e2.getValue().compareTo(e1.getValue()));
                }
            });
             
            //Printing the repeated words in input file along with their occurrences
             
            //System.out.println("Repeated Words In Input File Are :");
			
			
             
            for (Entry<String, Integer> entry : list) 
            {
                if (entry.getValue() > 3)
                {
                    //System.out.println(entry.getKey() + " : "+ entry.getValue());
                    keywords.put(entry.getKey(), entry.getValue());
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
		return keywords;
    }
}
