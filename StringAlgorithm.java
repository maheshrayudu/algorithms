import java.util.HashMap;

class CharCount {
    public int count;
    public int indx;

    public CharCount( int indx ) {
        this.count = 1;
        this.indx = indx;
    }

    public void IncrementCount() {
        this.count++;
    }
}
class StringAlgorithm {
    static final int MAX_VALUE = 256;
    static HashMap<Character, CharCount> charMap = new HashMap<Character, CharCount>(MAX_VALUE);
    
    static void readChars(String inputStr) {
        for (int i=0; i<inputStr.length(); i++) {
            if(charMap.containsKey(inputStr.charAt(i))){
                charMap.get(inputStr.charAt(i)).IncrementCount();                
            } else {
                charMap.put(inputStr.charAt(i), new CharCount(i));
            }
        }
    }

    static int firstNonRepeatChar(String inputStr) {
        int result = MAX_VALUE, i;
        readChars(inputStr);
        for(i=0; i<inputStr.length(); i++){
            if(charMap.get(inputStr.charAt(i)).count == 1 && result > charMap.get(inputStr.charAt(i)).indx){
                result = charMap.get(inputStr.charAt(i)).indx;
            }
        }

        return result;
    }

    public static void main(String[] args){
        String str = "IamReadIngRepeat";
        int position = firstNonRepeatChar(str);
        System.out.println(str.charAt(position));
        System.out.println("This is sample program");
    }
}