/**
 * Created by rainvagel on 21/03/15.
 */

import java.util.ArrayList;
import java.util.Arrays;

//Muutujad siin sees muutuvad, kui sudoku genereeritud

class Väljastus {

    private Ruudustik ruudustik;

    Väljastus(Ruudustik ruudustik) {
        this.ruudustik = ruudustik;
    }

    String väljasta() {
        for (int i = 0; i < ruudustik.getRidadeNr();i++) {
            ArrayList<Integer> rida = (ArrayList<Integer>) ruudustik.genereerimine().get(i);
            for (int j = 0; j < ruudustik.getRidadeNr();j++) {
                System.out.print("|" + rida.get(j) + "|");
            }
            System.out.println("");
            for (int j = 0; j < ruudustik.getRidadeNr()*3;j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        return "";
    }
}
