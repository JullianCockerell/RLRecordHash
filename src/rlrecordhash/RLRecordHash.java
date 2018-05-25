package rlrecordhash;
import java.io.*;
import java.util.*;


public class RLRecordHash {

    public static void main(String[] args) 
    {
        final String dir = System.getProperty("user.dir") + "/records.ser";
        File f = new File(dir);
        System.out.println(dir);
        //HashMap<Integer, RLRecord> map = new HashMap<Integer, RLRecord>();
        HashMap<Integer, RLRecord> map = null;
        if(f.exists() && !f.isDirectory()) 
        { 
            try
            {
                FileInputStream fis = new FileInputStream("records.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (HashMap) ois.readObject();
                ois.close();
                fis.close();
            }catch(IOException ioe)
            {
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c)
            {
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            RLRecord get = map.get(1);
            RLRecord get2 = map.get(2);
            System.out.println(get.getSaves());
            System.out.println(get2.getTime());
        }
        else
        {
            map = new HashMap<Integer, RLRecord>();
            RLRecord record1 = new RLRecord(1, 1, 1, 1, 1, 1);
            RLRecord record2 = new RLRecord(2, 2, 2, 2, 2, 2);
            RLRecord record3 = new RLRecord(3, 3, 3, 3, 3, 3);
            map.put(1, record1);
            map.put(2, record2);
            map.put(3, record3);
            try
           {
                FileOutputStream fos = new FileOutputStream("records.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(map);
                oos.close();
                fos.close();
                System.out.printf("Serialized HashMap data is saved in records.ser");
            }catch(IOException ioe)
            {
                  ioe.printStackTrace();
            }
        }
    }
    
}
