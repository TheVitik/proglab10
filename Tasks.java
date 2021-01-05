import java.util.ArrayList;
import java.util.Iterator;
public class Tasks {
    //Завдання №1
    public void MaxSalary(Firm firm){
        try{
            System.out.println(DoMaxSalary(firm)+"$");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public float DoMaxSalary(Firm firm) {
        if (firm.getDepartments().size()==0){
            if (firm.getOwner().isEmpty()) {
                throw new IllegalArgumentException("Фірма не має робітників");
            }
            else {
                throw new IllegalArgumentException("На фірмі є лише власник зі зарплатою 0$");
            }

        }
        int count=0;
        for (int i=0;i<firm.getDepartments().size();i++){
            if (firm.getDepartments().get(i).getWorkers().size()>0){
                count+=firm.getDepartments().get(i).getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("На фірмі взагалі ніхто не працює");
        }
        Iterator iterator = firm.getDepartments().iterator();
        float maxsalary=0f;
        while(iterator.hasNext()) {
            Iterator iter = ((Department)iterator.next()).getWorkers().iterator();
            while (iter.hasNext()){
                float salary=((Worker)iter.next()).getSalary();
                if (salary>maxsalary){
                    maxsalary=salary;
                }

            }
        }
        return maxsalary;
    }
    //Завдання №2
    public void HigherSalary(Firm firm){
        try{
            System.out.println(DoHigherSalary(firm));
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public String DoHigherSalary(Firm firm) {
        if (firm.getDepartments().size()==0){
            throw new IllegalArgumentException("Фірма не має відділів та робітників");
        }
        int count=0;
        for (int i=0;i<firm.getDepartments().size()-1;i++){
            if (firm.getDepartments().get(i).getWorkers().size()>0){
                count+=firm.getDepartments().get(i).getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("Фірма має відділи, проте в них жодного працівника");
        }
        ArrayList<Department> allDepartments = firm.getDepartments();
        ArrayList<Department> deps = new ArrayList<Department>(allDepartments);
        deps.remove(allDepartments.size()-1);
        String name="";
        for (Department d : deps ) {
            for (Worker w : d.getWorkers()) {
                int depidx = deps.indexOf(d)+1;
                float chiefsalary=allDepartments.get(allDepartments.size()-1).getWorkers().get(depidx).getSalary();
                float workersalary = w.getSalary();
                if (workersalary>chiefsalary){
                    name+=d.getName()+" ";
                }

            }
        }
        return name;
    }
    //Завдання №3
    public void WorkersList(Firm firm){
        try{
            System.out.println(DoWorkersList(firm).toString());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList<String> DoWorkersList(Firm firm) {
        if (firm.getDepartments().size()==0){
            if (firm.getOwner().isEmpty()) {
                throw new IllegalArgumentException("Фірма не має робітників");
            }
            else {
                throw new IllegalArgumentException(firm.getOwner());
            }
        }
        int count=0;
        for (int i=0;i<firm.getDepartments().size();i++){
            if (firm.getDepartments().get(i).getWorkers().size()>0){
                count+=firm.getDepartments().get(i).getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("На фірмі взагалі ніхто не працює");
        }
        ArrayList<String> allWorkersList = new ArrayList<>();
        Iterator<Department> iterator = firm.getDepartments().iterator();
        while(iterator.hasNext()) {
            Department dep = iterator.next();
            Iterator<Worker> iter = dep.getWorkers().iterator();
            while (iter.hasNext()){
                Worker worker = iter.next();
                allWorkersList.add(worker.getName() +" "+ worker.getSurname());
            }
        }
        return allWorkersList;
    }
}
