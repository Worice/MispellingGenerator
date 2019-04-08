import java.util.Random;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
//import info.debatty.java.stringsimilarity.*;

public class ErrorGenerator{

    private String sentence;
    private int errorRate2;
    private int sentenceLength;
    private Random errorType;
    private int modifyToken;
    private String outputSentence;    
    private StringTokenizer st;
    private Random errorChance;
    private int rows;
    private int tkLen;
    private int dist;

    public ErrorGenerator(String inputSentence, int errorRate, int sentencesToGenerate, int minTokenLen, int distance){
        st = new StringTokenizer(inputSentence);
        errorRate2 = errorRate;
        sentence = inputSentence;
        sentenceLength = st.countTokens();
        errorType = new Random();
        modifyToken = 0;
        errorChance = new Random();
        outputSentence = "";
        rows = sentencesToGenerate;
        tkLen = minTokenLen;
        dist = distance;
    }

    public int getStringsDistance(String correct, String corrupt){
        int distance = 0;
        KeysMap map = new KeysMap();
        for(int i = 0; i < correct.length() && i < corrupt.length(); ++i){
            distance += map.keysDistance(correct.charAt(i), corrupt.charAt(i));
        }
        return distance;
    }

    public void applyError(){
        rows *= st.countTokens();
        Random err = new Random();
            for(int i = 0; i < rows; ++i){
                System.out.printf("%s\t", sentence); 
                st = new StringTokenizer(sentence);
                while(st.hasMoreTokens()){
                    modifyToken = Math.abs(errorChance.nextInt(errorRate2) + 1);
                    if(modifyToken == 1){
                        int select = err.nextInt(4);
                        //select = 4;               
                        if(select == 1){
                            changeLetter(st.nextToken());
                        }
                        else if(select == 2){
                            swapChars(st.nextToken());
                        } 
                        else if(select == 3){
                            doubleLetter(st.nextToken());
                        }
                        else if(select == 4){
                            skipLetter(st.nextToken());
                        }
                    }else{
                        System.out.printf("%s ", st.nextToken());
                    }
                }

                System.out.printf("%c", '\n');
            }
        }

    public void changeLetter(String token){
        int tokenLen = token.length();
        String tmp = "";
            if(tokenLen > tkLen){
                do{
                    StringBuilder strBld = new StringBuilder(token);
                    Random a = new Random();
                    Random b = new Random();
                    char c = (char)(b.nextInt(26) + 'a');
                    strBld.setCharAt(a.nextInt(tokenLen), c);
                    tmp = strBld.toString();
                }while(getStringsDistance(token, tmp) > dist);   
                    System.out.printf("%s ", tmp);
            }
            else{
                System.out.printf("%s ", token);
            }
    }

    public void swapChars(String token){
        int tokenLen = token.length();
        String tmp = "";
        if(tokenLen > tkLen){
            do{
                StringBuilder strBld = new StringBuilder(token);
                Random a = new Random();
                Random b = new Random();
                int ch1 = a.nextInt(tokenLen - 1);
                int ch2 = ch1 + 1;
                char ch3 = strBld.charAt(ch1);
                strBld.setCharAt(ch1, strBld.charAt(ch2));
                strBld.setCharAt(ch2, ch3);
                tmp = strBld.toString();
            }while((getStringsDistance(token, tmp) / 8) > dist );   
        System.out.printf("%s ", tmp);
        }
        else{
            System.out.printf("%s ", token);
        }
    }

    public void doubleLetter(String token){
        int tokenLen = token.length();
        String tmp = "";
        if(tokenLen > tkLen){
            do{
                StringBuilder strBld = new StringBuilder(token);
                Random a = new Random();
                int posCh = a.nextInt(tokenLen);
                char ch = strBld.charAt(posCh);
                strBld.insert(posCh + 1, ch);
                tmp = strBld.toString();
            }while(getStringsDistance(token, tmp) > dist);            
                System.out.printf("%s ", tmp);
        }
        else{
            System.out.printf("%s ", token);
        }
    }

    public void skipLetter(String token){
        int tokenLen = token.length();
        String tmp = "";
        if(tokenLen > tkLen){
            do{
                StringBuilder strBld = new StringBuilder(token);
                Random a = new Random();
                int posCh = a.nextInt(tokenLen);
                strBld.deleteCharAt(posCh);
                tmp = strBld.toString();
            }while(getStringsDistance(token, tmp) > dist);
            System.out.printf("%s ", tmp);
        }
        else{
            System.out.printf("%s ", token);
        }
    }


    public void printSentence(){
        System.out.println(sentence);
    }
}


