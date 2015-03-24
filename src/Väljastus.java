/**
 * Created by rainvagel on 21/03/15.
 */

import java.util.ArrayList;

//Muutujad siin sees muutuvad, kui sudoku genereeritud

class Väljastus {

    private Ruudustik ruudustik;

    Väljastus(Ruudustik ruudustik) {
        this.ruudustik = ruudustik;
    }

    String väljasta() {
        int x = 0;
        for (int i = 0; i < ruudustik.getRidadeNr();i++) {
            ArrayList<Integer> rida = (ArrayList<Integer>) ruudustik.genereerimine().get(i);
            for (int j = 0; j < ruudustik.getRidadeNr();j++) {
                System.out.print("|" + rida.get(j) + "|");
                if (j % 3 == 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (x % 3 == 2 && i != ruudustik.getRidadeNr() - 1) {
                for (int j = 0; j < ruudustik.getRidadeNr()*3 + 3;j++) {
                    System.out.print("-");
                }
                System.out.println("");
            }
            for (int j = 0; j < ruudustik.getRidadeNr()*3 + 3;j++) {
                System.out.print("-");
            }
            System.out.println("");
            x++;
        }
        return "";
    }
}
