package exercice;

import java.util.ArrayList;
import java.util.List;

//réflexion entièrement fais par moi
public class Simplicite_meilleur {
    public static List<String> solution(String str, List<Character> ordre) {
        ArrayList<String> alMot = new ArrayList<String>();
        ArrayList<String> alMotTrie = new ArrayList<String>();
        String motCourant = "";
        for (char c : str.toCharArray()) {
            if ((c == ' ' || c == ',' || c == ';' || c == '?' || c == '!' || c == '\'') && !motCourant.isEmpty()) {
                alMot.add(motCourant);
                motCourant = "";
            } else if (c != ' ' && c != ',' && c != ';' && c != '?' && c != '!' && c != '\'')  { 
            	motCourant += c;
            }
        }
        alMot.add(motCourant);
        
        while (!alMot.isEmpty()) {
            String motMin = alMot.get(0);
            int indexMin = 0;
            for (int i = 1; i < alMot.size(); i++) {
                if (compareMots(alMot.get(i), motMin, ordre, 0)) {
                    motMin = alMot.get(i);
                    indexMin = i;
                }
            }
            alMotTrie.add(motMin);
            alMot.remove(indexMin);
        }
        
        return alMotTrie;
    }
    
    private static boolean compareMots(String mot1, String mot2, List<Character> ordre, int debutMot) {
    	int minLongueur;
    	if(mot1.length() < mot2.length()) {
    		minLongueur = mot1.length();
    	} else {
    		minLongueur = mot2.length();
    	}
        for (int i = debutMot; i < minLongueur; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            for(int j = 0; j < ordre.size(); j++) {
            	if(ordre.get(j) == c1 && ordre.get(j) == c2) {
            		compareMots(mot1, mot2, ordre, j + 1);
            	} else if(ordre.get(j) == c1) {
            		return true;
            	} else if(ordre.get(j) == c2) {
            		return false;
            	}
            }
            
        }
        if(mot1.length() < mot2.length()) {
    		return true;
    	} else {
    		return false;
    	}
    }
}


