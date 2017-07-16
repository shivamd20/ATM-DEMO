package ATM;

import java.awt.Frame;
import java.awt.Window;
import java.io.File;

import javax.swing.JFrame;
public  class CardDetect {
 Boolean notFound=true;
 File[] oldListRoot = File.listRoots();
static String dname="s";
 Thread t;
public  String waitForNotifying() throws Exception {

   t.start(); 
  while((dname=="s")){
	  Thread.sleep(5000);   
   }
   t.stop();
   return dname;
   
}
public CardDetect() {
	oldListRoot = File.listRoots();
	 t = new Thread(new Runnable() {
	       public void run() {
	    
	    	   int i=0;
		 while (true) 
		{
			 System.out.println(i++);
			 try {
				Thread.sleep(100);
				Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        try {
	        	
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	        if (File.listRoots().length > oldListRoot.length) {
	            System.out.println("new drive detected");
	            try {
	            	//cancel();
	            	  oldListRoot = File.listRoots();
	  	            System.out.println("drive"+oldListRoot[oldListRoot.length-1]+" detected");
	  	            
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	           
	            
	          
	            dname=oldListRoot[oldListRoot.length-1]+"";
	            System.out.println(dname);
	            }
	         else if (File.listRoots().length < oldListRoot.length) {
	        System.out.println(oldListRoot[oldListRoot.length-1]+" drive removed");
	        
	        try {
	        	dname="s";
			//	cancel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	       
	            oldListRoot = File.listRoots();
	        	
	         }
	       
	      
	    }
             }
	           
	       }
	   );
	
	// TODO Auto-generated constructor stub
}
void cancel()
{
	 try {
    Frame[] ob=	JFrame.getFrames();
   Window windows[]= JFrame.getWindows();
    for(Frame x :ob) {
 	   x.setVisible(false);
 	   x.dispose();
 	   }
    for(Window x :windows) {
  	   x.setVisible(false);
  	   x.dispose();
  	  
  	   }

	dname="s";
	 Thread.currentThread().stop();
	 
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 	  }
}