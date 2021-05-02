package jeujava;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
    
    public static PrintWriter pw = new PrintWriter(System.out, true);
    public static Scanner scan = new Scanner(System.in);
    
    private int nbLignes;
    private int nbColonnes;
    private String tab[][];
    private int tabInit[][];
    private String tabInd[] = {"+", "*", "-", ">"};
    private Case c;
    private Indice ind1;
    private Indice ind2;
    private IndiceSomme idS;
    private IndiceProduit idP;
    private IndiceSoust idSt;
    private IndiceSup idSup;
    private IndiceInf idInf;
    
    public void setNbLigne(int nl) {
        this.nbLignes = nl;
    }
    
    public void setNbColonnes(int nc) {
        this.nbColonnes = nc;
    }
    
    public void setCase(Case c) {
        this.c = c;
    }
    
    public void setIndice1(Indice i) {
        this.ind1 = i;
    }
    
    public void setIndice2(Indice i) {
        this.ind2 = i;
    }
    
    public void setIndiceSomme(IndiceSomme i) {
        this.idS = i;
    }
    
    public void setIndiceProduit(IndiceProduit i) {
        this.idP = i;
    }
    
    public void setIndiceSoust(IndiceSoust i) {
        this.idSt = i;
    }
    
    public void setIndiceSupe(IndiceSup i) {
        this.idSup = i;
    }
    
    public void setIndiceInf(IndiceInf i) {
        this.idInf = i;
    }
    
    public int getNbLignes() {
        return this.nbLignes;
    }
    
    public int getNbColonnes() {
        return this.nbColonnes;
    }
    
    public Case getCase() {
        return this.c;
    }
    
    public Indice getIndice1() {
        return this.ind1;
    }
    
    public Indice getIndice2() {
        return this.ind2;
    }
    
    public IndiceSomme getIndiceSomme() {
        return this.idS;
    }
    
    public IndiceProduit getIndiceProduit() {
        return this.idP;
    }
    
    public IndiceSoust getIndiceSoust() {
        return this.idSt;
    }
    
    public IndiceSup getIndiceSup() {
        return this.idSup;
    }
    
    public IndiceInf getIndiceInf() {
        return this.idInf;
    }
    
    public void dimensionsTab() {
        int l, c;
        do {
            pw.println("Entrez le nombre de lignes de votre tableau");
            String lignes = scan.nextLine();
            l = Integer.parseInt(lignes);
            this.setNbLigne(l);
            pw.println("Entrez le nombre de colonnes de votre tableau");
            String colonnes = scan.nextLine();
            c = Integer.parseInt(colonnes);
            this.setNbColonnes(c);
            if((l * c) % 2 != 0) {
                pw.println("Votre plateau n'aura pas un nombre paire de cases");
            }
        } while((l * c) % 2 != 0);
    }
    
    public void drawTab() {
        this.tab = new String[this.getNbLignes()][this.getNbColonnes()];
        for(int i = 0; i < this.getNbLignes(); i++) {
            for(int j = 0; j < this.getNbColonnes(); j++) {
                tab[i][j] = "#" + this.tabInd[(int)(4 * Math.random())] + " ";
                //tab[i][j] = "## ";
            }
        }
    }
    
    public void drawTabInit() {
        for(int i = 0; i < this.getNbLignes(); i++) {
            for(int j = 0; j < this.getNbColonnes(); j++) {
                pw.print(tab[i][j]);
            }
            pw.println();
        }
    }
    
    public void initPlateau() {
        this.drawTab();
        this.drawTabInit();
        this.tabInit = new int[this.getNbLignes()][this.getNbColonnes()];
        for(int i = 0; i < this.getNbLignes(); i++) {
            for(int j = 0; j < this.getNbColonnes(); j++) {
                tabInit[i][j] = (int)(9 * Math.random() + 1);
            }
        }
        
        for(int i = 0; i < this.getNbLignes(); i++) {
            for(int j = 0; j < this.getNbColonnes(); j++) {
                pw.print(tabInit[i][j] + " ");
            }
            pw.println();
        }
    }
    
    public void drawPlateau(ArrayList<Combinaison> l) {
        for(int i = 0; i < this.getNbLignes(); i++) {
            for(int j = 0; j < this.getNbColonnes(); j++) {
                for(int k = 0; k < l.size(); k++) {
                    if(i == l.get(k).getCase1().getLigne() && j == l.get(k).getCase1().getColonne()) {
                        this.tab[l.get(k).getCase1().getLigne()][l.get(k).getCase1().getColonne()] = this.getCase(l.get(k).getCase1().getLigne(), l.get(k).getCase1().getColonne()) + l.get(k).getCase1().getOperator() + " ";
                    }
                    else {
                        if(i == l.get(k).getCase2().getLigne() && j == l.get(k).getCase2().getColonne()) {
                            this.tab[l.get(k).getCase2().getLigne()][l.get(k).getCase2().getColonne()] = this.getCase(l.get(k).getCase2().getLigne(), l.get(k).getCase2().getColonne()) + l.get(k).getCase2().getOperator() + " ";
                        }
                    }
                }
            }
        }
        this.drawTabInit();
    }
    
    public int getCase(int i, int j) {
        return tabInit[i][j];
    }
    
    public Plateau(Indice i1, Indice i2, IndiceSomme sm, IndiceProduit pr, IndiceSoust st, IndiceSup sp, IndiceInf in) {
        this.setIndice1(i1);
        this.setIndice2(i2);
        this.setIndiceSomme(sm);
        this.setIndiceProduit(pr);
        this.setIndiceSoust(st);
        this.setIndiceSupe(sp);
        this.setIndiceInf(in);
    }

}
