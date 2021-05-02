package jeujava;

public class Combinaison {
    
    private Case case1;
    private Case case2;
    
    public void setCase1(Case c1) {
        this.case1 = c1;
    }
    
    public void setCase2(Case c2) {
        this.case2 = c2;
    }
    
    public Case getCase1() {
        return this.case1;
    }
    
    public Case getCase2() {
        return this.case2;
    }
    
    public Combinaison(Case c1, Case c2) {
        this.setCase1(c1);
        this.setCase2(c2);
    }

}
