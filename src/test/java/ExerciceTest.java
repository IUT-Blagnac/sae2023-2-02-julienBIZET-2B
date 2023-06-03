import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import exercice.Efficacite_meilleur;
import exercice.Simplicite_meilleur;
import java.util.*;

public class ExerciceTest {
    @Test
    public void testSolution() {
        // Chaine simple avec ordre complet
        assertEquals(List.of("666","the", "the", "number", "of", "beast"), Efficacite_meilleur.solution("666, the number of the beast",List.of('6', 't', 'n', 'o', 'b')));
        // Chaine à 1 mot
        assertEquals("Erreur de chaine à 1 mot", List.of("OK"), Efficacite_meilleur.solution("OK",List.of('a', 'b', 'c', 'd', 'e')));
        // Chaine vide initiale buggé
        // assertEquals(List.of(""), Exercice.solution("",List.of('6', 't', 'n', 'o', 'b')));
        // Chaine vide
        assertEquals(true, List.of("").equals(Efficacite_meilleur.solution("",List.of('6', 't', 'n', 'o', 'b'))) || Collections.emptyList().equals(Efficacite_meilleur.solution("",List.of('6', 't', 'n', 'o', 'b'))));
        // Chaine donnée en exemple
        assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"), Efficacite_meilleur.solution("Il fait beau aujourd'hui comme en aout",List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
        // Ajoutez vos test ici...
    }
}