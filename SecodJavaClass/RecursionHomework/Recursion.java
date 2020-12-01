import java.util.ArrayList;

// This class is just a demonstration on how to use recursion.
public class Recursion{

    // This method compares two Strings and determines if which one comes before or after in alphabetical order. If they are the same it returns 0;
    public static int compare(String s1, String s2){
        String lowerS1 = s1.toLowerCase();
        String lowerS2 = s2.toLowerCase();
        int returnValue = Character.compare(lowerS1.charAt(0), lowerS2.charAt(0));
        try{
            if(returnValue == 0){
                String newS1 = lowerS1.substring(1);
                String newS2 = lowerS2.substring(1);
                returnValue = compare(newS1, newS2);
            }
        } catch (StringIndexOutOfBoundsException s) {
            if(s1.length() < s2.length()){
                return -1;
            } else if(s1.length() > s2.length()) {
                return 1;
            } else {
                return 0;
            }
        }
        return returnValue;
    }

    // This method finds the minimum in the array of strings passed in using the compare method above.
    public static String findMinimum(String[] stringArray, int numStrings){
        String min;
        if(numStrings == 1){
            return stringArray[0];
        }
        int compareValue;
        String[] newArray = new String[numStrings-1];
        compareValue = compare(stringArray[0], stringArray[1]);
        if(compareValue < 0){
            newArray[0] = stringArray[0];
            for(int i = 1; i < numStrings-1; i++){
                newArray[i] = stringArray[i+1];
            }
            min = findMinimum(newArray, newArray.length);
        } else {
            for(int i = 0; i < numStrings-1; i++){
                newArray[i] = stringArray[i+1];
            }
            min = findMinimum(newArray, newArray.length);
        }
        return min;
    }

}