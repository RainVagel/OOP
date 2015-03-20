/**
 * Created by rainvagel on 20/03/15.
 */

import java.util.ArrayList;

public class Ruudustik {
    
    static int ridadeNr;
    static int veergudeNr;

    //Konstruktor

    Ruudustik(int ridadeNr, int veergudeNr) {
        this.ridadeNr = ridadeNr;
        this.veergudeNr = veergudeNr;
    }

    //Meetodid

    int getRidadeNr() {return ridadeNr;}
    int getVeergudeNr() {return veergudeNr;}

    void setRidadeNr(int ridadeNr) {this.ridadeNr = ridadeNr;}
    void setVeergudeNr(int veergudeNr) {this.veergudeNr = veergudeNr;}

    public static ArrayList<ArrayList> genereerimine() {
        ArrayList<ArrayList> veerud = new ArrayList<ArrayList>(veergudeNr);
        ArrayList<Integer> rida = new ArrayList<Integer>();
        int i = 0;
        while (i < ridadeNr) {
            veerud.add(rida);
            i++;
        }
        return veerud;
    }
}


