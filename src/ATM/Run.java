package ATM;

import java.awt.Frame;
import java.awt.Window;


import javax.swing.JFrame;

public class Run {
	
	static main window;
		
	public static void main(String[] args) {
		Run r=new Run();
		r.t.start();
	}
	 Thread t=new Thread(new Runnable() {
	public void run()  {
		try{
		window=new main();
			window.frmAtm.setVisible(true);
			while(true)
			if(window.cd.dname=="s")
			{
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
				window.frmAtm.dispose();
				window.t.stop();
				window.cd.t.stop();
				window=new main();
				window.frmAtm.setVisible(true);
				Thread.sleep(5000);
			}
			else
			{
				
				new CreateATM().UpdateATM();
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}});
}
