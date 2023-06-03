package exercice;

import java.util.ArrayList;
import java.util.List;

//fait entièrement avec chatgpt parce que je n'ai pas le temps sur mon temps personnel pour faire les différentes version
//parce que j'enchaine 2 job étudiant et quand j'ai fais remonté le problème on m'a dit que c'était pas grave je serai noté
//sur 18 ce qui ne me convient pas.import java.util.*;
public class Simplicite_pire{public static List<String> solution(String str, List<Character> ordre) {List<String> alMot = new ArrayList<>();str.chars().forEach(c -> {if (Character.isLetter(c)) alMot.add("");else if (!alMot.get(alMot.size()-1).isEmpty()) alMot.add("");else if (c != ' ') alMot.set(alMot.size()-1, alMot.get(alMot.size()-1) + (char) c);});alMot.sort((mot1, mot2) -> {int minLongueur = Math.min(mot1.length(), mot2.length());for (int i = 0; i < minLongueur; i++) {char c1 = mot1.charAt(i);char c2 = mot2.charAt(i);int indexC1 = ordre.indexOf(c1);int indexC2 = ordre.indexOf(c2);if (indexC1 != indexC2) return Integer.compare(indexC1, indexC2);}return Integer.compare(mot1.length(), mot2.length());});return alMot;}}



