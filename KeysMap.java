import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.lang.Math;

public class KeysMap{
    private Map<Character, Integer[]> keyMap;

    public KeysMap(){
        keyMap = new HashMap<>();
        keyMap.put('1', new Integer[] {0, 1});
        keyMap.put('2', new Integer[] {0, 2});
        keyMap.put('3', new Integer[] {0, 3});
        keyMap.put('4', new Integer[] {0, 4});
        keyMap.put('5', new Integer[] {0, 5});
        keyMap.put('6', new Integer[] {0, 6});
        keyMap.put('7', new Integer[] {0, 7});
        keyMap.put('8', new Integer[] {0, 8});
        keyMap.put('9', new Integer[] {0, 9});
        keyMap.put('0', new Integer[] {0, 10});
        keyMap.put('\'', new Integer[] {0, 11});
        keyMap.put('ì', new Integer[] {0, 12});
        keyMap.put('q', new Integer[] {1, 1});
        keyMap.put('w', new Integer[] {1, 2});
        keyMap.put('e', new Integer[] {1, 3});
        keyMap.put('r', new Integer[] {1, 4});
        keyMap.put('t', new Integer[] {1, 5});
        keyMap.put('y', new Integer[] {1, 6});
        keyMap.put('u', new Integer[] {1, 7});
        keyMap.put('i', new Integer[] {1, 8});
        keyMap.put('o', new Integer[] {1, 9});
        keyMap.put('p', new Integer[] {1, 10});
        keyMap.put('è', new Integer[] {1, 11});
        keyMap.put('é', new Integer[] {1, 14});
        keyMap.put('a', new Integer[] {2, 1});
        keyMap.put('s', new Integer[] {2, 2});
        keyMap.put('d', new Integer[] {2, 3});
        keyMap.put('f', new Integer[] {2, 4});
        keyMap.put('g', new Integer[] {2, 5});
        keyMap.put('h', new Integer[] {2, 6});
        keyMap.put('j', new Integer[] {2, 7});
        keyMap.put('k', new Integer[] {2, 8});
        keyMap.put('l', new Integer[] {2, 9});
        keyMap.put('ò', new Integer[] {2, 10});
        keyMap.put('à', new Integer[] {2, 11});
        keyMap.put('ù', new Integer[] {2, 12});
        keyMap.put('z', new Integer[] {3, 2});
        keyMap.put('x', new Integer[] {3, 3});
        keyMap.put('c', new Integer[] {3, 4});
        keyMap.put('v', new Integer[] {3, 5});
        keyMap.put('b', new Integer[] {3, 6});
        keyMap.put('n', new Integer[] {3, 7});
        keyMap.put('n', new Integer[] {3, 8});
        keyMap.put('m', new Integer[] {3, 9});
    }

    public Integer[] getCoordinates(char ch){
        Integer[] keyCoord = new Integer[2];
        for(Character key : keyMap.keySet()){
        }
        return keyCoord;      
    }

    public int keysDistance(char ch1, char ch2){
        return (Math.abs(keyMap.get(ch1)[0] - keyMap.get(ch2)[0]) + Math.abs(keyMap.get(ch1)[1] - keyMap.get(ch2)[1]));
    }
}
