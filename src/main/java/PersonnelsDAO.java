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
		try {

			FileOutputStream out = new FileOutputStream(file);
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(p);
	        oout.close();
		}
		catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
	}
	
	@Override
	public void update (Personnels p,String file) {
		
	}
}
