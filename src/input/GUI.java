package input;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GUI extends JFrame {

	JLabel info;
	InputFields input;
	SubmitButton submit;

	public GUI(String s) {
		super(s);
		this.setVisible(true);
		setLayout(new BorderLayout());
		info = new JLabel("Insert Name and Birthday(dd.mm):");
		add(info, BorderLayout.NORTH);
		input = new InputFields();
		add(input, BorderLayout.CENTER);
		submit = new SubmitButton();
		add(submit, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI("Input Birthday");
	}

}
