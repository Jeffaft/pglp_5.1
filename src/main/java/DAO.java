
interface DAO<T> {
	public abstract T read(String file);
	public abstract void update(T obj,String file );
	public abstract void write(T obj, String fle);
	

}
