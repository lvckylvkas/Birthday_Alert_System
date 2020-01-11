package input;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel info;
	InputFields input;
	SubmitButton submit;
	FileWriter fw;
	BufferedReader fr;

	//input gui
	public GUI(String s) {
		super(s);
		this.setVisible(true);
		setLayout(new BorderLayout());
		//add info label
		info = new JLabel("Insert Name and Birthday(dd.mm):");
		add(info, BorderLayout.NORTH);
		//add inputfields
		input = new InputFields();
		input.birthday.text.addActionListener(this);
		add(input, BorderLayout.CENTER);
		//add submitbutton
		submit = new SubmitButton();
		submit.button.addActionListener(this);
		add(submit, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//check if datepattern matches dayday.monthmonth, if not print "invalid date format"
		if (!input.birthday.text.getText().matches("[0123]\\d\\.[01]\\d")) {
			submit.label.setText("invalid date format");
			submit.label.setVisible(true);
		}
		//if yes, read in csv and add the inserted information
		else {
			String text = readCsv();
			text += input.name.text.getText() + ";" + input.birthday.text.getText() + "\r\n";
			writeCsv(text);
			submit.label.setText("Birthday saved");
			submit.label.setVisible(true);
		}

	}
	
	//reads in csvfile in resources
	public String readCsv() {
		try {
			fr = new BufferedReader(new FileReader("resources/birthdays.csv"));
			StringBuilder s = new StringBuilder();
			String row = "";
			while ((row = fr.readLine()) != null) {
				s.append(row + "\n");
			}
			fr.close();
			return s.toString().substring(0,s.toString().length()-1);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	//appends string s to csvfile
	public void writeCsv(String s) {
		try {
			fw = new FileWriter(new File("resources/birthdays.csv"));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.newLine();
			bw.close();
			input.clear();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI("Input Birthday");
	}

}
