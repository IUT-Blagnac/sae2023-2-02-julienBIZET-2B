package exercice;

import java.util.ArrayList;
import java.util.List;


// fait entièrement avec chatgpt parce que je n'ai pas le temps sur mon temps personnel pour faire les différentes version
// parce que j'enchaine 2 job étudiant et quand j'ai fais remonté le problème on m'a dit que c'était pas grave je serai noté
// sur 18 ce qui ne me convient pas.import java.util.ArrayList;
import java.util.List;

public class Efficacite_meilleur {
    public static List<String> solution(String str, List<Character> ordre) {
        ArrayList<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                if (motCourant.length() > 0) {
                    mots.add(motCourant.toString());
                    motCourant.setLength(0);
                }
            } else {
                motCourant.append(c);
            }
        }
        if (motCourant.length() > 0) {
            mots.add(motCourant.toString());
        }

        quickSort(mots, ordre, 0, mots.size() - 1);

        return mots;
    }

    private static void quickSort(List<String> mots, List<Character> ordre, int debut, int fin) {
        if (debut < fin) {
            int pivotIndex = partition(mots, ordre, debut, fin);
            quickSort(mots, ordre, debut, pivotIndex - 1);
            quickSort(mots, ordre, pivotIndex + 1, fin);
        }
    }

    private static int partition(List<String> mots, List<Character> ordre, int debut, int fin) {
        String pivot = mots.get(fin);
        int i = debut - 1;

        for (int j = debut; j < fin; j++) {
            if (compareMots(mots.get(j), pivot, ordre)) {
                i++;
                swap(mots, i, j);
            }
        }

        swap(mots, i + 1, fin);
        return i + 1;
    }

    private static boolean compareMots(String mot1, String mot2, List<Character> ordre) {
        int minLongueur = Math.min(mot1.length(), mot2.length());
        for (int i = 0; i < minLongueur; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            int indexC1 = ordre.indexOf(Character.toLowerCase(c1));
            int indexC2 = ordre.indexOf(Character.toLowerCase(c2));

            if (indexC1 != indexC2) {
                return indexC1 < indexC2;
            }
        }
        return mot1.length() <= mot2.length();
    }

    private static void swap(List<String> mots, int i, int j) {
        String temp = mots.get(i);
        mots.set(i, mots.get(j));
        mots.set(j, temp);
    }
}


