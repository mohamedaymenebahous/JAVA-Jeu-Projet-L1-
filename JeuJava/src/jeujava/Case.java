package jeujava;

public class Case {
    
    private int ligne;
    private int colonne;
    private String operator;
    
    public void setLigne(int l) {
        this.ligne = l;
    }
    
    public void setColonne(int c) {
        this.colonne = c;
    }
    
    public void setOperator(String c) {
        this.operator = c;
    }
    
    public int getLigne() {
        return this.ligne;
    }
    
    public int  getColonne() {
        return this.colonne;
    }
    
    public String getOperator() {
        return this.operator;
    }
    
    public boolean equals(Case c) {
        return this.getLigne() == c.getLigne() && this.getColonne() == c.getColonne();
    }
    
    public Case() {
        this.setLigne(0);
        this.setColonne(0);
    }
    
    public Case(int l, int c) {
        this.setLigne(l);
        this.setColonne(c);
    } 
    
}
