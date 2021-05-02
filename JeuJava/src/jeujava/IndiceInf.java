package jeujava;

public class IndiceInf extends Indice {
    
    public int getResult(int a, int b) {
        if(a < b) {
            return a;
        }
        else {
            return b;
        }
    }
    
}
