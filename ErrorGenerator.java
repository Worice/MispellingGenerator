import java.util.Random;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

/* Error generator */

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

    public ErrorGenerator(String inputSentence, int errorRate, int sentencesToGenerate){
        st = new StringTokenizer(inputSentence);
        errorRate2 = errorRate;
        sentence = inputSentence;
        sentenceLength = st.countTokens();
        errorType = new Random();
        modifyToken = 0;
        errorChance = new Random();
        outputSentence = "";
        rows = sentencesToGenerate;
    }

    public void applyError(){
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
        StringBuilder strBld = new StringBuilder(token);
        Random a = new Random();
        Random b = new Random();
        char c = (char)(b.nextInt(26) + 'a');
        strBld.setCharAt(a.nextInt(tokenLen), c);
        System.out.printf("%s ", strBld.toString());
    }

    public void swapChars(String token){
        int tokenLen = token.length();
        StringBuilder strBld = new StringBuilder(token);
        Random a = new Random();
        Random b = new Random();
        int ch1 = a.nextInt(tokenLen);
        int ch2 = a.nextInt(tokenLen);
        char tmp = strBld.charAt(ch1);
        strBld.setCharAt(ch1, strBld.charAt(ch2));
        strBld.setCharAt(ch2, tmp);
        System.out.printf("%s ", strBld.toString());
    }

    public void doubleLetter(String token){
        int tokenLen = token.length();
        StringBuilder strBld = new StringBuilder(token);
        Random a = new Random();
        int posCh = a.nextInt(tokenLen);
        char ch = strBld.charAt(posCh);
        strBld.insert(posCh + 1, ch);
        System.out.printf("%s ", strBld.toString());
    }

    public void skipLetter(String token){
        int tokenLen = token.length();
        StringBuilder strBld = new StringBuilder(token);
        Random a = new Random();
        int posCh = a.nextInt(tokenLen);
        strBld.deleteCharAt(posCh);
        System.out.printf("%s ", strBld.toString());
    }


    public void printSentence(){
        System.out.println(sentence);
    }
}


