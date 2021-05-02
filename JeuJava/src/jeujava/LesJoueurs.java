package jeujava;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LesJoueurs {
    
    public static Scanner scan = new Scanner(System.in);
    public static PrintWriter pw = new PrintWriter(System.out, true);
    
    private ArrayList<Joueur> lstJ;
    public Indice id;
    
    public LesJoueurs() {
        this.lstJ = new ArrayList<Joueur>();
    }
    
    public void ajoutJoueurs(Joueur j) {
        this.lstJ.add(j);
    }

    public int getNbJoueurs() {
        return this.lstJ.size();
    }

    public Joueur getJoueur(int i) {
        return this.lstJ.get(i);
    }
    
    public void initJoueurs() {
        String answer, nom1, nom2;
        pw.println("Qui sont les joueurs ?");
        nom1 = scan.nextLine();
        Joueur j1 = new Joueur(nom1);
        this.ajoutJoueurs(j1);
        do {
            pw.println("Vous voulez ajouter un joueur? (Oui/Non)");
            answer = scan.nextLine();
            if(answer.equals("Oui") || answer.equals("oui") || answer.equals("OUI")) {
                pw.println("Entrez le nom du joueur:");
                nom2 = scan.nextLine();
                Joueur j2 = new Joueur(nom2);
                this.ajoutJoueurs(j2);
            }
        } while(answer.equals("Oui") || answer.equals("oui") || answer.equals("OUI"));
        pw.println("Cractéristiques du jeu:");
        pw.println("Les Joueurs: ");
        pw.println("--------------------------------");
        for(Joueur j : this.lstJ) {
            pw.print("Joueur " + j.getNomJoueur());
            pw.print("   Score: " + j.getScore());
            pw.println();
        }
        pw.println("--------------------------------");
        pw.println("Les natures d'indices :" + "'+'" + "," + "'*'" + "," + "'-'"+ "," + "'>'");
        pw.println("Valeur maximale des cases: 9");
        pw.println();
    }

    public void tourJoueur(int i) {
//        pw.print("Joueur " + this.getJoueur(i).getNomJoueur());
//        pw.print("   Score: " + this.getJoueur(i).getScore());
//        pw.print(" Joue:");
        pw.println(this.getJoueur(i).toString() + " Joue");
        pw.println();
    }

}
