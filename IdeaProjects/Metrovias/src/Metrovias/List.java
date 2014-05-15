package Metrovias;

public interface List {
    public void addBefore(Object elem);
    public void addNext(Object elem);
    public void next();
    public void before();
    public void goTo(int x);
    public boolean isEmpty();
    public void empty();
    public Object showWindow();
    public void delete();
    public void modify(Object elem);
    public int length();
}
