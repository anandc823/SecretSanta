import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
/**
 * Automatically assigns individuals in a list names.txt to one another.
 * 
 * @author Anand Chitale
 * @version 1.0
 */
public class SecretFriend
{
    public static void loadWords(String fileName, ArrayList<String> a)
    {
        Scanner in;
        
        try
        {
            in = new Scanner(new File(fileName));
            // above creates a Scanner object that reads from the specified file
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("FileNotFoundException: " + e.getMessage());
            return;
        }
        
        while (in.hasNextLine())
        {
                a.add(in.nextLine());   // adds the next line of text to a as an element of the ArrayList
        }        
    }
    public static void getPeople(String filename){
       ArrayList<String> names = new ArrayList<String>();
       loadWords(filename, names);
       ArrayList<String> randomized = new ArrayList<String>();
       loadWords(filename, randomized);
       for(int i = randomized.size(); i>0;i--){
           int current = ((int)(i*Math.random()));
           randomized.add(randomized.get(current));
           randomized.remove(randomized.get(current));
       }
       for(int i = 0; i<=randomized.size()-1;i++){
           if(i<randomized.size()-1){
               System.out.println(randomized.get(i)+" is assigned to " + randomized.get(i+1));
           }
           else{
               System.out.println(randomized.get(randomized.size()-1)+ " is assigned to " + randomized.get(0));
            }
        }
    }
    public static void main(String[] args){
           getPeople("names.txt");
    }
}
