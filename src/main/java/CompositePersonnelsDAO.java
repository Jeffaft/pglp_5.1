import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CompositePersonnelsDAO implements DAO<CompositePersonnels> {
	public CompositePersonnelsDAO() {
		
	}
	@Override
	public CompositePersonnels read(String file) {
		CompositePersonnels cp = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	        cp = (CompositePersonnels) ois.readObject();
	        ois.close();
	        
		}
        catch (Exception ex) {
	         ex.printStackTrace();
	      }
		return cp;
	}
	
	@Override
	public void write(CompositePersonnels cp,String file) {
		try {

			FileOutputStream out = new FileOutputStream(file);
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(cp);
	        oout.close();
		}
		catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
	
	@Override
	public void update (CompositePersonnels cp,String file) {
		
	}
}
