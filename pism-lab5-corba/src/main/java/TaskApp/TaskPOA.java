package TaskApp;


/**
* TaskApp/TaskPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Task.idl
* 2 мая 2019 г. 21:45:56 MSK
*/

public abstract class TaskPOA extends org.omg.PortableServer.Servant
 implements TaskApp.TaskOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createList", new java.lang.Integer (0));
    _methods.put ("getVowels", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // TaskApp/Task/createList
       {
         this.createList ();
         out = $rh.createReply();
         break;
       }

       case 1:  // TaskApp/Task/getVowels
       {
         String $result = null;
         $result = this.getVowels ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:TaskApp/Task:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Task _this() 
  {
    return TaskHelper.narrow(
    super._this_object());
  }

  public Task _this(org.omg.CORBA.ORB orb) 
  {
    return TaskHelper.narrow(
    super._this_object(orb));
  }


} // class TaskPOA
