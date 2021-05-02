package jeujava;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
    
    public static PrintWriter pw = new PrintWriter(System.out, true);
    public static Scanner scan = new Scanner(System.in);
    public static int essai;
    private LesJoueurs lj;
    private Plateau plt;
    private int case1;
    private int case2;
    private Case Case1;
    private Case Case2;
    private Indice id;
    private String reponseHyp;
    private ArrayList<Combinaison> combinaisonList = new ArrayList<Combinaison>();
    
    public void setPlateau(Plateau p) {
        this.plt = p;
    } 
    
    public void setLesJoueurs(LesJoueurs l) {
        this.lj = l;
    }
    
    public void setIndice(Indice i) {
        this.id = i;
    }
    
    public void setCase1(int a) {
        this.case1 = a;
    }
    
    public void setCase2(int b) {
        this.case2 = b;
    }
    
    public void setCase1prime(Case c1) {
        this.Case1 = c1;
    }
    
    public void setCase2prime(Case c2) {
        this.Case2 = c2;
    }
    
    public void setReponseHyp(String s) {
        this.reponseHyp = s;
    }
    
    public Plateau getPlateau() {
        return this.plt;
    }
    
    public LesJoueurs getLesJoueurs() {
        return this.lj;
    }
    
    public int getCase1() {
        return this.case1;
    }
    
    public int getCase2() {
        return this.case2;
    }
    
    public Case getCase1prime() {
        return this.Case1;
    }
    
    public Case getCase2prime() {
        return this.Case2;
    }
     
    public Indice getIndice() {
        return this.id;
    }
    
    public String getReponseHyp() {
        return this.reponseHyp;
    }
    
    public void initJeu() {
        this.plt.dimensionsTab();
        this.lj.initJoueurs();
        this.plt.initPlateau();
        essai = 0;
        pw.println();
        do {
            for(int i = 0; i < this.lj.getNbJoueurs(); i++) {
                this.lj.tourJoueur(i);
                this.choixPremiereCase();
                this.choixDeuxiemeCase();
                int aleat = (int)(4 * Math.random() + 1);
                this.indicePremiereCase(aleat);
                int aleat1;
                do {
                    aleat1 = (int)(4 * Math.random() + 1);
                } while(aleat == aleat1);
                this.indiceDeuxiemeCase(aleat1);
                pw.println("Indice première case : " + this.getPlateau().getIndice1().getIndice1());
                pw.println("Indice deuxième case : " + this.getPlateau().getIndice2().getIndice2());
//                if(aleat == 4) {
//                    pw.println("Indice première case : " + this.getPlateau().getIndice1().getIndice1() + ">" + this.getPlateau().getIndiceInf().getResult(this.getCase1(), this.getCase2()));
//                } else {
//                    pw.println("Indice première case : " + this.getPlateau().getIndice1().getIndice1());
//                }
//                if(aleat1 == 4) {
//                    pw.println("Indice deuxième case : " + this.getPlateau().getIndice2().getIndice2() + ">" + this.getPlateau().getIndiceInf().getResult(this.getCase1(), this.getCase2()));
//                } else {
//                    pw.println("Indice deuxième case : " + this.getPlateau().getIndice2().getIndice2());
//                }
                pw.println();
                this.verificationHyp(i);
            }
        } while(essai != ((this.getPlateau().getNbLignes() * this.getPlateau().getNbColonnes()) / 2));
    }
    
    public void choixPremiereCase() {
        pw.println("Choix de la première case");
        pw.println("Numéro de ligne entre 1 et " + this.plt.getNbLignes() + " : ");
        String ls;
        int l;
        do {
            ls = scan.nextLine();
            try {
                l = Integer.parseInt(ls);
            } catch(NumberFormatException e) {
                pw.println("Entrez un 'numéro' de ligne entre 1 et " + this.plt.getNbLignes() + " : ");
                ls = scan.nextLine();
                l = Integer.parseInt(ls);
            }
            if(l > this.plt.getNbLignes() || l < 1) {
                pw.println("Valeur hors limites ; recommencez !");
            }
        } while(l > this.plt.getNbLignes() || l < 1);
        pw.println("Numéro de colonne entre 1 et " + this.plt.getNbColonnes() + " : ");
        String cs;
        int c;
        do {
            cs = scan.nextLine();
            try {
                c = Integer.parseInt(cs);
            } catch(NumberFormatException e) {
                pw.println("Entrez un 'numéro' de colonne entre 1 et " + this.plt.getNbColonnes() + " : ");
                cs = scan.nextLine();
                c = Integer.parseInt(cs);
            }
            if(c > this.plt.getNbColonnes() || c < 1) {
                pw.println("Valeur hors limites ; recommencez !");
            }
        } while(c > this.plt.getNbColonnes() || c < 1);
        this.setCase1(this.plt.getCase(l - 1, c - 1));
        Case case1 = new Case(l - 1, c - 1);
        this.setCase1prime(case1);
    }
    
    public void choixDeuxiemeCase() {
        pw.println("Choix de la deuxième case");
        pw.println("Numéro de ligne entre 1 et " + this.plt.getNbLignes() + " : ");
        String l1s;
        int l1;
        do {
            l1s = scan.nextLine();
            try {
                l1 = Integer.parseInt(l1s);
            } catch(NumberFormatException e) {
                pw.println("Entrez un 'numéro' de ligne entre 1 et " + this.plt.getNbLignes() + " : ");
                l1s = scan.nextLine();
                l1 = Integer.parseInt(l1s);
            }
            if(l1 > this.plt.getNbLignes() || l1 < 1) {
                pw.println("Valeur hors limites ; recommencez !");
            }
        } while(l1 > this.plt.getNbLignes() || l1 < 1);
        pw.println("Numéro de colonne entre 1 et " + this.plt.getNbColonnes() + " : ");
        String c1s;
        int c1;
        do {
            c1s = scan.nextLine();
            try {
                c1 = Integer.parseInt(c1s);
            } catch(NumberFormatException e) {
                pw.println("Entrez un 'numéro' de colonne entre 1 et " + this.plt.getNbColonnes() + " : ");
                c1s = scan.nextLine();
                c1 = Integer.parseInt(c1s);
            }
            if(c1 > this.plt.getNbColonnes() || c1 < 1) {
                pw.println("Valeur hors limites ; recommencez !");
            }
        } while(c1 > this.plt.getNbColonnes() || c1 < 1);
        this.setCase2(this.plt.getCase(l1 - 1, c1 - 1));
        Case case2 = new Case(l1 - 1, c1 - 1);
        this.setCase2prime(case2);
    }
    
    public void indicePremiereCase(int aleat) {
        switch(aleat) {
            case 1 : 
                this.getPlateau().getIndice1().setIndice1(this.getPlateau().getIndiceSomme().getResult(this.getCase1(), this.getCase2()));
                this.getCase1prime().setOperator("+");
                //this.getPlateau().getIndice1().setOperator1("+");
                break;
            case 2 : 
                this.getPlateau().getIndice1().setIndice1(this.getPlateau().getIndiceProduit().getResult(this.getCase1(), this.getCase2()));
                this.getCase1prime().setOperator("*");
                //this.getPlateau().getIndice1().setOperator1("*");
                break;
            case 3 : 
                this.getPlateau().getIndice1().setIndice1(this.getPlateau().getIndiceSoust().getResult(this.getCase1(), this.getCase2()));
                this.getCase1prime().setOperator("-");
                //this.getPlateau().getIndice1().setOperator1("-");
                break;
            case 4 : 
                this.getPlateau().getIndice1().setIndice1(this.getPlateau().getIndiceSup().getResult(this.getCase1(), this.getCase2()));
                this.getCase1prime().setOperator(">");
                //this.getPlateau().getIndice1().setOperator1(">");
                break;
        }
    }
    
    public void indiceDeuxiemeCase(int aleat) {
        switch(aleat) {
            case 1 : 
                this.getPlateau().getIndice2().setIndice2(this.getPlateau().getIndiceSomme().getResult(this.getCase1(), this.getCase2()));
                this.getCase2prime().setOperator("+");
                //this.getPlateau().getIndice2().setOperator2("+");
                break;
            case 2 : 
                this.getPlateau().getIndice2().setIndice2(this.getPlateau().getIndiceProduit().getResult(this.getCase1(), this.getCase2()));
                this.getCase2prime().setOperator("*");
                //this.getPlateau().getIndice2().setOperator2("*");
                break;
            case 3 : 
                this.getPlateau().getIndice2().setIndice2(this.getPlateau().getIndiceSoust().getResult(this.getCase1(), this.getCase2()));
                this.getCase2prime().setOperator("-");
                //this.getPlateau().getIndice2().setOperator2("-");
                break;
            case 4 : 
                this.getPlateau().getIndice2().setIndice2(this.getPlateau().getIndiceSup().getResult(this.getCase1(), this.getCase2()));
                this.getCase2prime().setOperator(">");
                //this.getPlateau().getIndice2().setOperator2(">");
                break;
        }
    }
    
    public void verificationHyp(int i) {
        pw.println("Veux-tu faire des hypothèses sur les valeurs des cases choisies (oui/non) :");
        this.setReponseHyp(scan.nextLine());
        if(this.getReponseHyp().equals("oui") || this.getReponseHyp().equals("Oui") || this.getReponseHyp().equals("OUI") || this.getReponseHyp().equals("o") || this.getReponseHyp().equals("O")) {
            pw.println("Valeur de la première case : ");
            String cs1S = scan.nextLine();
            int cs1 = Integer.parseInt(cs1S);
            pw.println("Valeur de la deuxième case : ");
            String cs2S = scan.nextLine();
            int cs2 = Integer.parseInt(cs2S);
            if(cs1 == this.getCase1() && cs2 == this.getCase2()) {
                pw.println("Bravo ! Le contenu des cases a été trouvé !");
                essai++;
                pw.println();
                this.lj.getJoueur(i).setScore(this.lj.getJoueur(i).getScore() + this.getCase1() + this.getCase2());
                pw.println(this.lj.getJoueur(i).toString());
                this.combinaisonList.add(new Combinaison(this.getCase1prime(), this.getCase2prime()));
                this.getPlateau().drawPlateau(this.combinaisonList);
            }
            else {
                pw.println("Raté!");
                pw.println();
                this.lj.getJoueur(i).setScore(this.lj.getJoueur(i).getScore());
                pw.println(this.lj.getJoueur(i).toString());
            }
        }
    }
    
    public Jeu(Plateau p, LesJoueurs l) {
        this.setPlateau(p);
        this.setLesJoueurs(l);
    }
    
    public Jeu() {
        this.setPlateau(plt);
        this.setLesJoueurs(lj);
    }
    
}
