
/**
 * Created by rainvagel on 27/03/15.
 */

class Lahendaja {
    static int[][] sudoku = {{6,7,1,0,0,2,0,3,0},{0,2,4,0,0,7,0,9,1},{0,0,0,1,8,6,0,4,7},
            {0,3,8,4,0,0,9,1,0},{1,0,0,3,9,8,0,0,2},{4,0,2,0,6,0,3,0,8},{9,0,0,2,7,0,5,8,0},
            {2,4,0,8,0,0,1,6,0},{0,8,3,0,1,9,0,0,4}};


    static boolean vaatlejaVerikaalne(int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == number) {
                return true;
            }
        }
        return false;
    }
    static boolean vaatlejaHoristonaalne(int x, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == number) {
                return true;
            }
        }
        return false;
    }

    static boolean vaatlejaKast(int x, int y, int number) {
        for (int i = 0; i < getVäikeKast(x, y).length;i++) {
            if (getVäikeKast(x, y)[i] == number) {
                return true;
            }
        }
        return false;
    }

    static boolean onVahel (int arv1, int arv2, int arv3) {
        return arv1 <= arv3 && arv1 >= arv2;
    }

    static int[] getVäikeKast(int x, int y) {
        if (onVahel(x,0,2) && onVahel(y,0,2)) {
            return väikeseLoomine(0,2,0,2);
        }
        else if (onVahel(x,3,5) && onVahel(y,0,2)) {
            return väikeseLoomine(3,5,0,2);
        }
        else if (onVahel(x,6,8) && onVahel(y,0,2)) {
            return väikeseLoomine(6,8,0,2);
        }
        else if (onVahel(x,0,2) && onVahel(y,3,5)) {
            return väikeseLoomine(0,2,3,5);
        }
        else if (onVahel(x,0,2) && onVahel(y,6,8)) {
            return väikeseLoomine(0,2,6,8);
        }
        else if (onVahel(x,3,5) && onVahel(y,3,5)) {
            return väikeseLoomine(3,5,3,5);
        }
        else if (onVahel(x,3,5) && onVahel(y,6,8)) {
            return väikeseLoomine(3,5,6,8);
        }
        else if (onVahel(x,6,8) && onVahel(y,3,5)) {
            return väikeseLoomine(6,8,3,5);
        }
        else{
            return väikeseLoomine(6,8,6,8);
        }
    }

    static int[] väikeseLoomine(int a, int b, int c, int d) {
        int[] kast = new int[9];
        for (int i = a; i < b; i++) {
            for (int j = c; j < d; j++) {
                kast[c] = sudoku[i][j];
            }
        }
        return kast;
    }

    static boolean sobilik(VäikeRuut väikene, int num) {
        if (vaatlejaHoristonaalne(väikene.getRida(), num)) {
            return false;
        } else if (vaatlejaVerikaalne(väikene.getVeerg(), num)) {
            return false;
        } else if (vaatlejaKast(väikene.getRida(), väikene.getVeerg(), num)) {
            return false;
        }
        return true;
    }

    static VäikeRuut getJärgmineVäikeRuut(VäikeRuut hetkel) {
        int rida = hetkel.rida;
        int veerg = hetkel.veerg;

        veerg++;

        if (veerg > 8) { //Liigub järgmisele reale
            veerg = 0;
            rida++;
        }
        if (rida > 8) { //Siin saab läbi
            return null;
        }

        VäikeRuut järgmine = new VäikeRuut(rida, veerg);
        return järgmine;
    }

    static boolean lahenda(VäikeRuut hetkel) {
        if (hetkel == null) {
            return true;
        }
        if (sudoku[hetkel.rida][hetkel.veerg] != 0){
            return lahenda(getJärgmineVäikeRuut(hetkel));
        }
        for (int i = 1; i <= 9; i++) {
            if (!sobilik(hetkel,i)) {
                continue;
            }
            sudoku[hetkel.getRida()][hetkel.getVeerg()] = i;
            if (lahenda(getJärgmineVäikeRuut(hetkel))) {
                return true;
            }
            else {
                sudoku[hetkel.getRida()][hetkel.getVeerg()] = 0;
            }
        }
        return false;
    }

    static void väljasta(int[][] sudoku) {
        int x = 0;
        for (int i = 0; i < 9;i++) {
            for (int j = 0; j < 9;j++) {
                System.out.print("|" + sudoku[i][j] + "|");
                if (j % 3 == 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (x % 3 == 2 && i != 9 - 1) {
                for (int j = 0; j < 9*3 + 3;j++) {
                    System.out.print("-");
                }
                System.out.println("");
            }
            for (int j = 0; j < 9*3 + 3;j++) {
                System.out.print("-");
            }
            System.out.println("");
            x++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Algne");
        väljasta(sudoku);
        System.out.println();
        lahenda(new VäikeRuut(0,0));
        System.out.println("Lahendatud!");
        väljasta(sudoku);
    }
}