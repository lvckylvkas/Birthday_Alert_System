import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class Test extends JFrame{
	
	JPasswordField j;
	
	public Test() {
		this.setVisible(true);
		j = new JPasswordField();
		add(j);
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(j.getText());
				
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();

	}

}
