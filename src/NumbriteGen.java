import java.util.ArrayList;
import java.util.Random;

public class NumbriteGen {
	/*
	public static void main(String[] args){
		NumbriteGen lol = new NumbriteGen(9);
        System.out.println(lol.numbrid());
	}*/
	private int q;
	
	NumbriteGen(int q){
		this.q = q; 
	}

	public ArrayList<Integer> numbrid(){
		Random generator = new Random();
        ArrayList<Integer> x =new ArrayList<Integer>();
        int z = 0;
        while (z<9){
        	int l = generator.nextInt(9)+1;
        	if (x.contains(l)){
        		
        	}
        	else{
        		x.add(l);
        		z++;
        	}
        }
        return x;
        
	}

}
