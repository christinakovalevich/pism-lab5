
import TaskApp.Task;
import TaskApp.TaskHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {

    public static void main(String[] args) {

        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "creator";
            Task creator = TaskHelper.narrow(ncRef.resolve_str(name));
            creator.createList();

            System.out.println(creator.getVowels());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}