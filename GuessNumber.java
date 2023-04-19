package guessnumber;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




class Guessnum extends JFrame implements ActionListener{

    JTextField t1;
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3;
    int n,user;
	
	{
		 n = (int)Math.round(Math.random()*100);
		
	}
	
	   
	  Guessnum(){
		  
		  
		  setLayout(null);
		  Font f = new Font("Monotype Corsiva",Font.BOLD,30);
		  Font f2 = new Font("MS Mincho",Font.BOLD,20);
		  
		  l1 = new JLabel("Guess My Number ?");
		  l1.setBounds(100,30,1000,100);
		  l1.setFont(new Font("Impact",Font.BOLD,60));
		  l1.setForeground(new Color(255,5,0));
		  add(l1);
		  
		  l2 = new JLabel("Enter a number between 1-100");
		  l2.setBounds(130,100,500,100);
		  l2.setFont(f);
		  add(l2);
		  
		  l4 = new JLabel("Welcome to My Game");
		  l4.setBounds(100,165,550,100);
		  l4.setHorizontalAlignment(JTextField.CENTER);
		  l4.setForeground(new Color(0,162,232));
		  l4.setFont( new Font("MV Boli",Font.BOLD,20));
		  add(l4);
		  
		  t1 = new JTextField(3);
		  t1.setBounds(250,260,150,50);
		  t1.setHorizontalAlignment(JTextField.CENTER);
		  t1.setFont(f);
		  add(t1);
		  
		  l3 = new JLabel("Try and guess it !");
		  l3.setBounds(180,300,500,100);
		  l3.setFont(f);
		  add(l3);
		  
		  
		  
		  b1 = new JButton("Guess");
		  b1.setBounds(250,400,150,50);
		  b1.setBackground(new Color(255,128,128));
		  b1.setFont(f2);
		  add(b1);
		  
		    
		  b2 = new JButton("Give Up!");
		  b2.setBounds(100,500,150,50);
		  b2.setBackground(new Color(118,255,118));
		  b2.setFont(f2);
		  add(b2);

            
		  b3 = new JButton("Play Again!");
		  b3.setBounds(400,500,170,50);
		  b3.setBackground(new Color(121,121,255));
		  b3.setFont(f2);
		  add(b3);
    
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  b3.addActionListener(this);		  
		  
	  }
	  
	  void random_num(){
		   n = (int)Math.round(Math.random()*100);
	  }
	  
	  
	  public void actionPerformed(ActionEvent e){
		  if(e.getSource() == b1){
			  String s = t1.getText();
			    user = Integer.parseInt(s);
			  if(user == n ){
				 l4.setForeground(new Color(238,17,177));
				 l4.setText("Your are Winner .Correct Number is a "+ n );
			  }
			  
			  else if(user < n){
				  l4.setForeground(new Color(128,0,0));
				 l4.setText("Your guess is too low.");
				  
			  }
			  
			  else{
				  l4.setForeground(new Color(0,0,233));
				 l4.setText("Your guess is too high.");
		
			  }
			  t1.setText("");

		  }
		  
		  if(e.getSource() == b2){
			     l4.setForeground(new Color(99,26,255));
				 l4.setText("Correct Number is a "+ n);
		  }
		  
		  if(e.getSource() == b3){
			   random_num();    
		  }
	  }
	  
} 


class GuessNumber{
	public static void main (String ar[]){
		Guessnum g = new Guessnum();
		g.setVisible(true);
		g.setBounds(50,20,900,700);
                g.getContentPane().setBackground(new Color(148,239,227));
		g.setDefaultCloseOperation(g.EXIT_ON_CLOSE);
	}
}