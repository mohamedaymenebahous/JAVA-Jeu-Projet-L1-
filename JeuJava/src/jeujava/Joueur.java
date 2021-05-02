package jeujava;

public class Joueur {
    
    private int score;
    private String nomJoueur;
    
    public void setScore(int s) {
        this.score = s;
    }
    
    public void setNomJoueur(String n) {
        this.nomJoueur = n;
    }
    
    public int getScore() {
        return this.score; 
    }
    
    public String getNomJoueur() {
        return this.nomJoueur;
    }
    
    public Joueur(int scr, String nom) {
        this.setScore(scr);
        this.setNomJoueur(nom);
    }
    
    public Joueur(String nom) {
        this.setNomJoueur(nom);
        this.setScore(0);
    }
    
    public String toString() {
        return "Joueur " + this.getNomJoueur() + " Score: " + this.getScore() + ".";
    }

}
