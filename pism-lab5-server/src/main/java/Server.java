
import TaskApp.Task;
import TaskApp.TaskHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {

    public static void main(String[] args) {

        try {
            System.out.println("Server started..");
            ORB orb = ORB.init(args, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            TaskWorker creator = new TaskWorker();

            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(creator);
            Task href = TaskHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "creator";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            while (true) {
                orb.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
