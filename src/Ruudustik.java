/**
 * Created by rainvagel on 20/03/15.
 */

import java.util.ArrayList;

class Ruudustik {

//    Testimiseks
//    public static void main(String[] args) {
//        Ruudustik üheksa = new Ruudustik(9);
//        System.out.println(üheksa.genereerimine());
//    }
    
    private int ridadeNr;

    //Konstruktor

    Ruudustik(int ridadeNr) {
        this.ridadeNr = ridadeNr;
    }

    //Meetodid

    int getRidadeNr() {return ridadeNr;}

    void setRidadeNr(int ridadeNr) {this.ridadeNr = ridadeNr;}

    public ArrayList genereerimine() {
        ArrayList<ArrayList> veerud = new ArrayList<ArrayList>();
        ArrayList<Integer> rida = new ArrayList<Integer>();
        int j = 0;
        while (j < ridadeNr) {
            rida.add(0);
            j++;
        }
        int i = 0;
        while (i < ridadeNr) {
            veerud.add(rida);
            i++;
        }
        return veerud;
    }
}


