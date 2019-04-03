/* java MispellingGenerator errorProbability generatedSentences minimun tokenlenght */

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.FileNotFoundException;

public class MispellingGenerator{
    
    public static void main(String[] args)
    throws FileNotFoundException{

    //Import Data
     Scanner s = new Scanner(new File(args[0]));
     ArrayList<String> list = new ArrayList<String>();
     while (s.hasNextLine()){
             list.add(s.nextLine());
     }
     s.close();
    

    //Iterate over Data
    ListIterator<String> it = list.listIterator();
    while(it.hasNext()){
        ErrorGenerator errGen = new ErrorGenerator(it.next(), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        errGen.applyError();
        //System.out.println();
    }
    }
}


 
