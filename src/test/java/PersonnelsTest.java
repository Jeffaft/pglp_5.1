import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*
;public class PersonnelsTest {

	@Test
	public void PersonnelsSeria() {
		try {
			Personnels p = new Personnels.Builder("ju","rey","directeur").build();
			
			File fichier =  new File("test.io");
			
			//ecriture dans le fichier
			FileOutputStream out = new FileOutputStream("test.io");
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(p);
	        oout.close();
	    
	        //lecture dans le fichier
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.io"));
	        Personnels p2 = (Personnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(p.toString());
	        System.out.println(p2.toString());
	        assertEquals(p.toString(),p2.toString());
	        
		} catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
	}
	@Test
	public void CompositeSeria() {
		try {
			Personnels p=new Personnels.Builder("ju","rey","dev1").build();
			Personnels p1=new Personnels.Builder("ju","rey2","dev2").build();
			CompositePersonnels equipe= new CompositePersonnels();
			equipe.add(p);
			equipe.add(p1);
			
			File fichier =  new File("test.io");
			
			//ecriture dans le fichier
			FileOutputStream out = new FileOutputStream("test.io");
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(equipe);
	        oout.close();
	    
	        //lecture dans le fichier
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.io"));
	        CompositePersonnels equipe2 = (CompositePersonnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(equipe.toString());
	        System.out.println(equipe2.toString());
	        assertEquals(equipe.toString(),equipe2.toString());
	        
		} catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
	}

}
