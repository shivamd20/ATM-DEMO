package ATM;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;		
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CreateATM {
	String str;
	Connection con;
	 JFrame frame;
	 JTextField textField;
	JLabel txtName;
	JLabel txtBal;
	JLabel txtMob;
	JLabel txtpin;
	JLabel txtAdd;
	String dname;
	ResultSet rs;
	String name;
	String balance;
	String accNo;
	String accPin;
	JButton Go;
	JButton btnCreateAtmCard;
	private JLabel lblNewLabel_1;

	public CreateATM() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A/c No");
		lblNewLabel.setBounds(62, 34, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(140, 31, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 btnCreateAtmCard = new JButton("Create ATM Card");
		btnCreateAtmCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			try {
					getDBConnection();
				fileCreate();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnCreateAtmCard.setBounds(266, 215, 158, 23);
		frame.getContentPane().add(btnCreateAtmCard);
		
		 txtName = new JLabel("Name");
		txtName.setBounds(62, 76, 223, 14);
		frame.getContentPane().add(txtName);
		
		txtBal = new JLabel("Balance");
		txtBal.setBounds(62, 101, 213, 14);
		frame.getContentPane().add(txtBal);
		
		 txtAdd = new JLabel("Address");
		txtAdd.setBounds(62, 126, 213, 14);
		frame.getContentPane().add(txtAdd);
		
		txtMob = new JLabel("mobile");
		txtMob.setBounds(62, 153, 258, 14);
		frame.getContentPane().add(txtMob);
		
		 Go = new JButton("GO");
		Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDBConnection();
				try {
					PreparedStatement ps=
							con.prepareStatement("select * from myprojectdb.BANK_TB  where ACC_NO=?");
					ps.setInt(1,Integer.parseInt(textField.getText()));	
					 rs=ps.executeQuery();
					while(rs.next())
					{
						name=rs.getString(4);
						balance=String.valueOf(rs.getInt(1));
						accPin=String.valueOf(rs.getInt(5));
						accNo=String.valueOf(textField.getText());
						txtName.setText("Name:-"+"'"+String.valueOf(rs.getString(4))+"'");
						txtBal.setText("Bal.:- "+"'"+rs.getInt(1)+"'");
						txtAdd.setText("ADD:-  "+"'"+rs.getString(2)+"'");
						txtMob.setText("MOB:-  "+"'"+rs.getString(3)+"'");
						txtpin.setText("PIN:-"+"'"+rs.getInt(5)+"'");
						
							str=txtName.getText()+txtBal.getText()+txtAdd.getText()+txtMob.getText()+txtpin.getText()+textField.getText();
							System.out.println(str);
						
					}
				}
				catch(Exception e5){ e5.printStackTrace();}
				
			}
		});
		Go.setBounds(274, 30, 89, 23);
		frame.getContentPane().add(Go);
		 
		 lblNewLabel_1 = new JLabel("Your Card Must Be Inserted.");
		 lblNewLabel_1.setBounds(62, 219, 164, 14);
		 frame.getContentPane().add(lblNewLabel_1);
		
		 txtpin = new JLabel("PIN");
		txtpin.setBounds(62, 179, 195, 14);
		frame.getContentPane().add(txtpin);
	}

public   void getDBConnection()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","ramu");
		//JOptionPane.showMessageDialog(null, "DataBase Connected");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
 void fileCreate() 
{
	 try{
		 File[] files;
			files= File.listRoots();
			String dname=String.valueOf(files[File.listRoots().length-1]);
		
	 File fi=new File(dname+"A.txt");
	// fi.setReadable(false);
	 FileOutputStream f=new FileOutputStream(fi);
	 DataOutputStream out = new DataOutputStream(f);

	 	System.out.println(str);
	 	DataEncrypt();
	 	System.out.println(str);
		  out.writeUTF(str);
		  out.close();
	  f.close();
		System.out.println("Card made");
		 
	 }
	 catch(Exception e)
	 {e.printStackTrace();}
	
	}
	void DataDecrypt()
	{
		 int i=0; 
		 while(i<str.length())
		  {
			 char x=(char) (str.charAt(i)-'a');
			 if(!(str.charAt(i)+"").equals("'"))
			str= str.replace(str.charAt(i), x);
			 i++;
		  }
	}
	void DataEncrypt()
	{
		 int i=0; 
		 while(i<str.length())
		  {
			 char x=(char) (str.charAt(i)+'a');
			 if(!(str.charAt(i)+"").equals("'"))
			str= str.replace(str.charAt(i), x);
			 i++;
		  }
	}
void UpdateATM() throws Exception
{
	CardDetails cd=new CardDetails();
	cd.btnNewButton.doClick();
	cd.DataDecrypt();
	cd.getContent();
	textField.setText(cd.accno);
	Go.doClick();
	fileCreate();
}
void UpdateDataBase(int amount,int preBal,int accNo)
{
try
{
	getDBConnection();
	PreparedStatement ps=
			con.prepareStatement("update myprojectdb.BANK_TB set ACC_BAL=?  where ACC_NO=?");
	ps.setInt(1, preBal-amount);				
	ps.setInt(2, accNo);		
	ps.executeUpdate();
	JOptionPane.showMessageDialog(null, "Transaction Complete");
}
catch(Exception e1)
{
	e1.printStackTrace();
}
}
void UpdateDataBase(int amount,int accNo)
{
try
{
	CreateATM cA=new CreateATM();
	cA.textField.setText(accNo+"");
	cA.Go.doClick();
	getDBConnection();
	PreparedStatement ps=
			con.prepareStatement("update myprojectdb.BANK_TB set ACC_BAL=?  where ACC_NO=?");
	ps.setInt(1, Integer.parseInt(cA.balance)+amount);				
	ps.setInt(2, accNo);		
	ps.executeUpdate();

}
catch(Exception e1)
{
	e1.printStackTrace();
}
}
public static void main(String ...args)
{
	new CreateATM().frame.setVisible(true);
	}
void UpdateDataBasePin(int pin ,int accNo)
{
try
{
	getDBConnection();
	PreparedStatement ps=
			con.prepareStatement("update myprojectdb.BANK_TB set ATM_PIN=?  where ACC_NO=?");
	ps.setInt(1, pin);				
	ps.setInt(2, accNo);		
	ps.executeUpdate();
	JOptionPane.showMessageDialog(null, "PIN Changed");
	CardDetect.dname="s";
}
catch(Exception e1)
{
	e1.printStackTrace();
}
}
}

