package input;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements ActionListener {

	JLabel info;
	InputFields input;
	SubmitButton submit;
	FileWriter fw;
	BufferedReader fr;

	public GUI(String s) {
		super(s);
		this.setVisible(true);
		setLayout(new BorderLayout());
		info = new JLabel("Insert Name and Birthday(dd.mm):");
		add(info, BorderLayout.NORTH);
		input = new InputFields();
		input.birthday.text.addActionListener(this);
		add(input, BorderLayout.CENTER);
		submit = new SubmitButton();
		submit.button.addActionListener(this);

		add(submit, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!input.birthday.text.getText().matches("\\d\\d\\.\\d\\d")) {
			submit.label.setText("invalid date format");
			submit.label.setVisible(true);
		} else {
			String text = readCsv();
			text += input.name.text.getText() + ";" + input.birthday.text.getText() + "\r\n";
			writeCsv(text);
			submit.label.setText("Birthday saved");
			submit.label.setVisible(true);

		}

	}
	
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
