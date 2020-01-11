package output;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.Style;

public class GUI extends JFrame{
	
	Checker c;
	
	public GUI(String s) {
		super(s);
		this.setVisible(true);
		JTextArea output = new JTextArea();
		Checker c = new Checker();
		String result = "";
		for(String name : c.getBirthdayPeople())
			result += name + " has Birthday!\n";
		output.setText(result);
		add(output);
		output.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new GUI("Birthday Alert");

	}

}
