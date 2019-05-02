package TaskApp;


/**
* TaskApp/TaskHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Task.idl
* 2 мая 2019 г. 21:45:56 MSK
*/

abstract public class TaskHelper
{
  private static String  _id = "IDL:TaskApp/Task:1.0";

  public static void insert (org.omg.CORBA.Any a, TaskApp.Task that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static TaskApp.Task extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (TaskApp.TaskHelper.id (), "Task");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static TaskApp.Task read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TaskStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, TaskApp.Task value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static TaskApp.Task narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof TaskApp.Task)
      return (TaskApp.Task)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      TaskApp._TaskStub stub = new TaskApp._TaskStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static TaskApp.Task unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof TaskApp.Task)
      return (TaskApp.Task)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      TaskApp._TaskStub stub = new TaskApp._TaskStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}