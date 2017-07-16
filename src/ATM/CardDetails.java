package ATM;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardDetails {

	 JFrame frame;
	public String name,add,accno,accbalance,atmpin,mob;
	 JLabel labaccno, labaccmob,labaccbal,labaccname,labaccadd,lblpin;
	 JButton btnNewButton;
	 String str=null;


		public static void main(String ...args)
		{
			new CardDetails().frame.setVisible(true);
		}
	public CardDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 612, 396);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Information");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD , 17));
		lblNewLabel.setBounds(232, 28, 200, 65);
		frame.getContentPane().add(lblNewLabel);
		
		labaccno = new JLabel("A/c No.-");
		labaccno.setBounds(71, 80, 476, 14);
		frame.getContentPane().add(labaccno);
		
		 labaccname = new JLabel("Name");
		labaccname.setBounds(71, 105, 476, 14);
		frame.getContentPane().add(labaccname);
		
		labaccbal = new JLabel("Balance");
		labaccbal.setBounds(71, 130, 476, 14);
		frame.getContentPane().add(labaccbal);
		
		 labaccadd = new JLabel("address");
		labaccadd.setBounds(71, 155, 476, 14);
		frame.getContentPane().add(labaccadd);
		
		 labaccmob = new JLabel("Mob.");
		labaccmob.setBounds(71, 180, 476, 14);
		frame.getContentPane().add(labaccmob);
		
		 btnNewButton = new JButton("check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContent();
				labaccadd.setText(labaccadd.getText()+"   "+add);
				lblpin.setText(lblpin.getText()+"   "+atmpin);
				labaccno.setText(labaccno.getText()+"   "+accno);
				labaccmob.setText(labaccmob.getText()+"   "+mob);
				labaccname.setText(labaccname.getText()+"   "+name);
				labaccbal.setText(labaccbal.getText()+"   "+accbalance);
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(427, 301, 120, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Please insert Your Card to check your card details");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 23));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(21, 223, 537, 50);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblpin = new JLabel("PIN.");
		lblpin.setBounds(71, 208, 166, 14);
		frame.getContentPane().add(lblpin);
	
	}  
	String[] fileOpen()
	{
		String content[]=null;
		
		
		try {	
			File[] files;
			files= File.listRoots();
			str=String.valueOf(files[File.listRoots().length-1]);
			System.out.println("data="+str);
		 FileInputStream f;
		
			f = new FileInputStream(str+"A.txt");
			//f = new FileInputStream("k://"+"A.txt");
		DataInputStream in = new DataInputStream(f);
		 str=in.readUTF();
		 DataDecrypt();
		in.close();
		  content=str.split("'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return content;
	}
	void getContent()
	{
	//if(!(CardDetect.dname.equals("s")))
		if(true)
	{
	String[] strall =fileOpen();
	name=strall[1];
	accbalance=strall[3];
	add=strall[5];
	atmpin=strall[9];
	mob=strall[7];
	accno=strall[10];
	System.out.println("accno"+accno);

	}


	}
	void DataDecrypt()
	{
		 int i=0; 
		 while(i<str.length())
		  {
			 char x=(char) (str.charAt(i)-'a');
			 if(!(str.charAt(i)+"").equals("'"))
			 str=str.replace(str.charAt(i), x);
			 i++;
		  }
	}
}
