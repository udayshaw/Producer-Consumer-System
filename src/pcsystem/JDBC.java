/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pcsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Uday
 */
public class JDBC {
        Connection con;
        public void connect()
        {
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
                System.out.println("Connected..");
            }catch(Exception ex){ex.printStackTrace();}
        }
 public boolean login(String uid, String pwd){
        boolean b = false;
        try{
            PreparedStatement pt = con.prepareStatement("select PASSWORD from CUSTOMER_DETAILS where CUSTOMER_ID=?");
            pt.setString(1,uid);

            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                String p = rs.getString(1);
                if(p.equals(pwd)){
                    b = true;
                }
            }

        }catch(Exception ex){ex.printStackTrace();}

        return b;
    }

  public void postOrder(String oid,String date, int oamt){

        try{
            PreparedStatement pt = con.prepareStatement("update ORDER_DETAILS set DELIVERY_DATE=?, AMOUNT=?, STATUS=? where ORDER_ID=?");

            pt.setString(1,date);
            pt.setInt(2,oamt);
            pt.setString(3,"Placed");
            pt.setString(4,oid);
            pt.executeUpdate();

        }catch(Exception ex){ex.printStackTrace();}
       }

  public void createuser(String uid,String pwd){

        try{
            PreparedStatement pt = con.prepareStatement("insert into CUSTOMER_DETAILS values(?,?)");

            pt.setString(1,uid);
            pt.setString(2,pwd);
           
            pt.executeUpdate();

        }catch(Exception ex){ex.printStackTrace();}
       }

 public void postReply(String pid,String pname,int pquan,int pmrp,int pcp){
       String p = "id";
        try{
            PreparedStatement pt = con.prepareStatement("insert into PRODUCT_DETAILS values(?,?,?,?,?,?)");
            
            pt.setString(1,p);
            pt.setString(2,pid);
            pt.setString(3,pname);
            pt.setInt(4,pquan);
            pt.setInt(5,pmrp);
            pt.setInt(6,pcp);
            pt.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
       }
 
 public void additem(String uid,String oid, String pid,int quan){
       try{
            PreparedStatement pt = con.prepareStatement("insert into PLACE_ORDERS values(?,?,?,?)");
            pt.setString(1,uid);
            pt.setString(2,oid);
            pt.setString(3,pid);
            pt.setInt(4,quan);
            pt.executeUpdate();
            
            
        }catch(Exception ex){ex.printStackTrace();}
       }
 
 public void addtoOrder(String uid,String oid,String date){
       
        try{
 PreparedStatement pt = con.prepareStatement("insert into ORDER_DETAILS values(?,?,?,?,?)");
            int p=0;
            pt.setString(1,oid);
            pt.setString(2,uid);
            pt.setString(3,date);
            pt.setInt(4,p);
            pt.setString(5,"UNPLACED");
            pt.executeUpdate();
         }catch(Exception ex){ex.printStackTrace();}
       }    
            
 public void delQuery(String pid){
     
       try{
            PreparedStatement pt = con.prepareStatement("DELETE FROM PRODUCT_DETAILS where PRODUCT_ID=?");
            pt.setString(1,pid);
            pt.executeUpdate();
       }catch(Exception ex){ex.printStackTrace();}
    
     
 }


  public String showReply(String oid,String uid){
      String q = null,u=null;
      try{
            PreparedStatement st = con.prepareStatement("select CUSTOMER_ID from ORDER_DETAILS where ORDER_ID=?");
             st.setString(1,oid);
             ResultSet sr = st.executeQuery();
             if(sr.next())
             u = sr.getString(1);
            if(uid.equals(u))
            {
                PreparedStatement dt = con.prepareStatement("select STATUS from ORDER_DETAILS where ORDER_ID=?");
               dt.setString(1,oid);
            ResultSet rs = dt.executeQuery();
            if(rs.next())
              q=rs.getString(1);
            }
            else
                q = "Wrong Data Entered";
      }catch(Exception ex){ex.printStackTrace();}
      return q;
  }

  public String showStatus(String oid,String uid){
      String q = null,u=null;
      try{
            PreparedStatement st = con.prepareStatement("select CUSTOMER_ID from ORDER_DETAILS where ORDER_ID=?");
             st.setString(1,oid);
             ResultSet sr = st.executeQuery();
             if(sr.next())
             u = sr.getString(1);
            if(uid.equals(u))
            {
                PreparedStatement dt = con.prepareStatement("select Delivery_Date  from ORDER_DETAILS where ORDER_ID=?");
               dt.setString(1,oid);
            ResultSet rs = dt.executeQuery();
            if(rs.next())
              q=rs.getString(1);
            }
            else
                q = "Wrong Data Entered";
      }catch(Exception ex){ex.printStackTrace();}
      return q;
  }
  
  public int showAmount(String oid,String uid){
      String u=null;
      int q = 0;
      try{
            PreparedStatement st = con.prepareStatement("select CUSTOMER_ID from ORDER_DETAILS where ORDER_ID=?");
             st.setString(1,oid);
             ResultSet sr = st.executeQuery();
             if(sr.next())
             u = sr.getString(1);
            if(uid.equals(u))
            {
                PreparedStatement dt = con.prepareStatement("select AMOUNT  from ORDER_DETAILS where ORDER_ID=?");
               dt.setString(1,oid);
            ResultSet rs = dt.executeQuery();
            if(rs.next())
              q=rs.getInt(1);
            }
      }catch(Exception ex){ex.printStackTrace();}
      return q;
  }

  public String showProductName(String pid){
      String q = null;
      try{
            
                PreparedStatement dt = con.prepareStatement("select PRODUCT_NAME from PRODUCT_DETAILS where PRODUCT_ID=?");
               dt.setString(1,pid);
               ResultSet rs = dt.executeQuery();
            while(rs.next())
              q=rs.getString(1);
            }
           catch(Exception ex){ex.printStackTrace();}
      return q;
  }
  
  public int showQuantity(String pid){
      int q = 0;
      try{
            
               PreparedStatement dt = con.prepareStatement("select QUANTITY from PRODUCT_DETAILS where PRODUCT_ID=?");
               dt.setString(1,pid);
               ResultSet rs = dt.executeQuery();
               while(rs.next())
               q=rs.getInt(1);
            }
           catch(Exception ex){ex.printStackTrace();}
      return q;
  }
  public int showMRP(String pid){
      int q = 0;
      try{
            
                PreparedStatement dt = con.prepareStatement("select MRP from PRODUCT_DETAILS where PRODUCT_ID=?");
               dt.setString(1,pid);
               ResultSet rs = dt.executeQuery();
            while(rs.next())
              q=rs.getInt(1);
            }
           catch(Exception ex){ex.printStackTrace();}
      return q;
  }
  
  public int showCostPrice(String pid){
      int q = 0;
      try{
            
                PreparedStatement dt = con.prepareStatement("select COST_PRICE from PRODUCT_DETAILS where PRODUCT_ID=?");
               dt.setString(1,pid);
               ResultSet rs = dt.executeQuery();
            while(rs.next())
              q=rs.getInt(1);
            }
           catch(Exception ex){ex.printStackTrace();}
      return q;
  }


    public String showCol(){
        String q = null;
        try{
            PreparedStatement dt = con.prepareStatement("select PRODUCT_ID and PRODUCT_NAME from PRODUCT_DETAILS");
               ResultSet rs = dt.executeQuery();
            while(rs.next())
              q=rs.getString(1);
        }
        catch(Exception ex){ex.printStackTrace();}
        return q;
        
    }
        public boolean primary(String qe){
            boolean p = true;
            String q = null;
            try{
            PreparedStatement dt = con.prepareStatement("select CUSTOMER_ID from CUSTOMER_DETAILS");
            ResultSet rs = dt.executeQuery();
            while(rs.next()){
              q=rs.getString(1);
              if(q.equals(qe))
              {
                  p = false;
              }
            }
         }
        catch(Exception ex){ex.printStackTrace();}
        return p;
        }

        public boolean checkPid(String pid)
        {
            boolean p = true;
            String q = null;
            try{
            PreparedStatement dt = con.prepareStatement("select PRODUCT_ID from PRODUCT_DETAILS");
            ResultSet rs = dt.executeQuery();
            while(rs.next()){
              q=rs.getString(1);
              if(q.equals(pid))
              {
                  p = false;
              }
            }
         }
        catch(Exception ex){ex.printStackTrace();}
        return p;
        }
      
 public boolean checkOrderId(String oid){
            boolean p = true;
            String q = null;
            try{
            PreparedStatement dt = con.prepareStatement("select ORDER_ID from PLACE_ORDERS");
            ResultSet rs = dt.executeQuery();
            while(rs.next()){
              q=rs.getString(1);
              if(q.equals(oid))
              {
                  p = false;
              }
            }
          }
        catch(Exception ex){ex.printStackTrace();}
        return p;
        }
  public boolean checkStatus(String oid){
            boolean p = true;
            String q = "Placed",w=null;
            try{
            PreparedStatement dt = con.prepareStatement("select STATUS from ORDER_DETAILS where ORDER_ID=?");
            dt.setString(1,oid);
            ResultSet rs = dt.executeQuery();
            while(rs.next()){
              w=rs.getString(1);
              if(q.equals(w))
              {
                  p = false;
              }
            }
          }
        catch(Exception ex){ex.printStackTrace();}
        return p;
        }


      public void close(){
        try{
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

    }
}
