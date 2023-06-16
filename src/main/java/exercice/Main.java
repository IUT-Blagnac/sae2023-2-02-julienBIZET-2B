package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "exemple de texte exemplaire exemples a zoing classer wario 672 exemplaires exemplairem xylophone mignon ae at";
        List<Character> ordre = List.of('c', 't', 'e', '6', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');

        // Augmentation de la taille du texte
        StringBuilder texteAugmente100 = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            texteAugmente100.append(texte);
        }

        StringBuilder texteAugmente1000 = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            texteAugmente1000.append(texte);
        }

        // Période de chauffe
        for (int i = 0; i < 5; i++) {
            Exercice1.solution(texte, ordre);
        }

        long totalTimeNormal = 0;
        long totalTimeAugmente100 = 0;
        long totalTimeAugmente1000 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime(); // Temps de départ
            Exercice1.solution(texte, ordre);
            long endTime = System.nanoTime(); // Temps d'arrêt
            long executionTimeNormal = endTime - startTime; // Temps d'exécution normal en nanosecondes
            totalTimeNormal += executionTimeNormal;

            startTime = System.nanoTime(); // Temps de départ
            Exercice1.solution(texteAugmente100.toString(), ordre);
            endTime = System.nanoTime(); // Temps d'arrêt
            long executionTimeAugmente100 = endTime - startTime; // Temps d'exécution augmenté de 100 fois en nanosecondes
            totalTimeAugmente100 += executionTimeAugmente100;

            startTime = System.nanoTime(); // Temps de départ
            Exercice1.solution(texteAugmente1000.toString(), ordre);
            endTime = System.nanoTime(); // Temps d'arrêt
            long executionTimeAugmente1000 = endTime - startTime; // Temps d'exécution augmenté de 1000 fois en nanosecondes
            totalTimeAugmente1000 += executionTimeAugmente1000;
        }

        double averageTimeNormal = totalTimeNormal / 5.0 / 1000000.0; // Temps d'exécution normal moyen en millisecondes
        double averageTimeAugmente100 = totalTimeAugmente100 / 5.0 / 1000000.0; // Temps d'exécution augmenté de 100 fois moyen en millisecondes
        double averageTimeAugmente1000 = totalTimeAugmente1000 / 5.0 / 1000000.0; // Temps d'exécution augmenté de 1000 fois moyen en millisecondes

        double ratio100 = averageTimeAugmente100 / averageTimeNormal; // Ratio moyen pour une augmentation de 100 fois
        double ratio1000 = averageTimeAugmente1000 / averageTimeNormal; // Ratio moyen pour une augmentation de 1000 fois

        System.out.println("Temps d'exécution normal moyen : " + averageTimeNormal + " ms");
        System.out.println("Temps d'exécution augmenté de 100 fois moyen : " + averageTimeAugmente100 + " ms");
        System.out.println("Temps d'exécution augmenté de 1000 fois moyen : " + averageTimeAugmente1000 + " ms");
        System.out.println("Ratio moyen pour une augmentation de 100 fois : " + ratio100);
        System.out.println("Ratio moyen pour une augmentation de 1000 fois : " + ratio1000);
    }
}