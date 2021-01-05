import java.util.ArrayList;

public class Firm {
    private final String name;
    private final String owner;
    private static ArrayList<Department> deps;

    public Firm(String name, String owner,ArrayList<Department> deps){
        this.name=name;
        this.owner=owner;
        this.deps=deps;
    }
    public String getName(){
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public ArrayList<Department> getDepartments(){
        return deps;
    }
    public void setDepartments(ArrayList<Department> deps){
        this.deps=deps;
    }
    public void addDepartment(String name,String chief,ArrayList<Worker> workers){
        deps.add(new Department(name,chief,workers));
    }
}
