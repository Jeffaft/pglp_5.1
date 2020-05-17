import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
public class PersonnelsDAO implements DAO<Personnels>{
	
	public PersonnelsDAO () {
		
	}
	@Override
	public Personnels read(String file) {
		Personnels p = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	        p = (Personnels) ois.readObject();
	        ois.close();
	        
		}
        catch (Exception ex) {
	         ex.printStackTrace();
	      }
		return p;
	}
	
	@Override
	public void write(Personnels p,String file) {
		
	}
	
	@Override
	public void update (Personnels p,String file) {
		
	}
}
