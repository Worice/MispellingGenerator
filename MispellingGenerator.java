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
        ErrorGenerator errGen = new ErrorGenerator(it.next(), 1);
        errGen.applyError();
        System.out.println();
    }
    }
}


 
