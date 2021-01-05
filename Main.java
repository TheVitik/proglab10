import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        //Створювання робітників
        Worker andrey = new Worker("Andrey","Noname",2000.00f);
        Worker vova = new Worker("Vova","Incognito",2100.00f);
        Worker bill = new Worker("Bill","Gates",800.00f);
        Worker mark = new Worker("Mark","Zuckerberg",600.00f);
        Worker larry = new Worker("Larry","Page",3000.00f);
        //Створювання відділів з робітниками
        Department programmers = new Department("Programmers","Evgeniy Kashtalyan",new ArrayList<Worker>(Arrays.asList(bill,mark)));
        Department designers = new Department("Designers","Nikita Hodnev",new ArrayList<Worker>(Arrays.asList(larry)));
        ArrayList<Department> deps = new ArrayList<Department>();

        deps.add(programmers);
        deps.add(designers);
        //Створення фірми з відділами
        Firm firm = new Firm("WorldEdit","Viktor Kobylynskyi",deps);
        //Додавання нового відділу у фірму
        firm.addDepartment("Managers","Somebody Else",new ArrayList<Worker>(Arrays.asList(vova,andrey)));
        Department managers = firm.getDepartments().get(2);
        //Додавання робітника у раніше створений відділ
        managers.addWorker("Tolik","Management",1000.00f);
        int len=firm.getDepartments().size();
        String[] own= firm.getOwner().split(" ");
        //Додавання власника фірми і директорів відділів у неіснуючий відділ Main
        Worker owner = new Worker(own[0],own[1],10000.00f);
        ArrayList main = new ArrayList<Worker>();
        main.add(owner);
        for (int i=0;i<len;i++) {
            String[] chief=deps.get(i).getChief().split(" ");
            Worker worker = new Worker(chief[0],chief[1],1000f*(i+1));
            main.add(worker);
        }
        firm.addDepartment("Main","Nobody",main);
        //Завдання 1-3
        Tasks tasks = new Tasks();
        tasks.MaxSalary(firm);
        tasks.HigherSalary(firm);
        tasks.WorkersList(firm);
    }

}